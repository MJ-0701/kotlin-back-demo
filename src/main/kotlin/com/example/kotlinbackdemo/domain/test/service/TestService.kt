package com.example.kotlinbackdemo.domain.test.service

import com.example.kotlinbackdemo.domain.test.data.repository.TestRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    private val testRepository: TestRepository
) {


}