package com.example.kotlinbackdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KotlinBackDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinBackDemoApplication>(*args)
}
