package com.example.kotlinbackdemo.domain.test.data.repository

import com.example.kotlinbackdemo.domain.test.data.Entity.Test
import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<Test, Long> {
}