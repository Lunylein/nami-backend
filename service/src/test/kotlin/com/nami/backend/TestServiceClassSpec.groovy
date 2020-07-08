package com.nami.backend

import com.nami.backend.test.TestEntity
import com.nami.backend.test.TestRepository
import com.nami.backend.test.TestService
import spock.lang.Specification
import spock.lang.Subject

class TestServiceClassSpec extends Specification{

    TestRepository repositoryMock = Mock()

    @Subject
    def sut  = new TestService(repositoryMock)

    def "creates new element in repository"(){
        given:
        def id = UUID.randomUUID()
        def name = "someName"
        def description = "someDescription"
        def repoInput = new TestEntity(null, 0, false, name, description)
        def repoOutput = new TestEntity(id, repoInput.version, repoInput.deleted, name, description)

        when:
        def result = sut.create(name, description)

        then:
        1 * repositoryMock.save({
            verifyAll(it, TestEntity) {
                id == repoOutput.id
                name == name
                description == description
                deleted == repoInput.deleted
            }
        }) >> repoOutput

        and:
        result == repoOutput
     }
}
