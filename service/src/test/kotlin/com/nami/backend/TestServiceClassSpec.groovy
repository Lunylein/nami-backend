package com.nami.backend

import com.nami.backend.test.TestEntity
import com.nami.backend.test.TestRepository
import com.nami.backend.test.TestService
import spock.lang.Specification
import spock.lang.Subject

class TestServiceClassSpec extends Specification{
    TestRepository testRepository = Mock(TestRepository)
    @Subject
    def sut  = new TestService(testRepository)

    def "creates new element in repository"(){
        given:
        def id = UUID.randomUUID()
        def name = "someName"
        def description = "someDescription"
        def testEntity = new TestEntity(id, 0L, false, name, description)
        testRepository.save() >> testEntity

        when:
        def result = sut.create(name, description)

        then:
        1 * testRepository.save(new TestEntity(null, 0L, false, name, description))
        result == testEntity
     }
}
