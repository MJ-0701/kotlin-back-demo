package com.example.kotlinbackdemo.global.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@OpenAPIDefinition(info = Info(
    title = "api 명세서",
    description = "api",
    version = "v1"
))
@Configuration
class SwaggerConfig {
    @Bean
    fun projectApi(): GroupedOpenApi? {
        val paths = arrayOf("/api/v1/**")
        return GroupedOpenApi
            .builder()
            .group("rest api")
            .pathsToMatch(*paths)
            .build()
    }
}