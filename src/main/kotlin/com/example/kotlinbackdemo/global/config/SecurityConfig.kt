package com.example.kotlinbackdemo.global.config

import com.example.kotlinbackdemo.global.config.jwt.JwtAuthenticationFilter
import com.example.kotlinbackdemo.global.config.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity.RequestMatcherConfigurer
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.*
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider
) {

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager? {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    @Order(0)
    fun resources(http: HttpSecurity): SecurityFilterChain {
        return http.requestMatchers { matchers: RequestMatcherConfigurer ->
            matchers
                .antMatchers("/resources/**")
        }
            .authorizeHttpRequests().anyRequest().permitAll()
            .and()
            .requestCache { obj: RequestCacheConfigurer<HttpSecurity> -> obj.disable() }
            .securityContext { obj: SecurityContextConfigurer<HttpSecurity> -> obj.disable() }
            .sessionManagement { obj: SessionManagementConfigurer<HttpSecurity> -> obj.disable() }
            .build()
    }

    @Bean
    fun configure(http : HttpSecurity) : SecurityFilterChain {
        return http
            .httpBasic().disable() // rest api만 고려 기본설정 해제
            .csrf().disable() // csrf 보안토큰 disable
            .addFilterBefore(
                JwtAuthenticationFilter(jwtTokenProvider),
                UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 사용안함
            .and()
            .authorizeRequests() // 요총에 대한 권한 체크
            .antMatchers("/api/v1/user/**").hasRole("USER") // 유저 api에는 유저권한 요청
            .anyRequest().permitAll()
            .and()
            .build()
    }


    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        configuration.setAllowedOriginPatterns(listOf("*"))
        configuration.allowedMethods =
            mutableListOf("HEAD", "POST", "GET", "DELETE", "PUT")
        configuration.allowedHeaders = listOf("*")
        configuration.allowCredentials = true
        configuration.addExposedHeader("Authorization")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}