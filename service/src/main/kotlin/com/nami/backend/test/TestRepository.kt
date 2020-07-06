package com.nami.backend.test

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TestRepository : JpaRepository<TestEntity, UUID>