package com.example.kotlinbackdemo.global.config.jwt

import com.example.kotlinbackdemo.domain.user.entity.Role
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider {

    private var secretKey = "Spring-Boot-Developer-MJ"

    // 토큰 유효시간 10분
    private val tokenValidTime = 10 * 60 * 1000L

    private val userDetailsService: UserDetailsService? = null

    // 객체 초기화, secretKey를 Base64로 인코딩
    @PostConstruct
    protected fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())
    }

    // JWT 토큰 생성
    fun createToken(userPk: String?, roles: Role?): String? {

        val claims: Claims = Jwts.claims().setSubject(userPk) // JWT payload 에 저장되는 정보단위, 보통 여기서 user를 식별하는 값을 넣는다.
        claims.put("roles", roles) // 정보는 key / value 쌍으로 저장된다.
        val now = Date()
        return Jwts.builder()
            .setClaims(claims) // 정보 저장
            .setIssuedAt(now)
            .setExpiration(Date(now.getTime() + tokenValidTime)) // set Expire Time
            .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secretKey) // 사용할 암호화 알고리즘과 signature 에 들어갈 secret값 세팅
            .compact()
    }

    // JWT 토큰에서 인증 정보 조회
    fun getAuthentication(token: String?): Authentication? {
        val userDetails = userDetailsService!!.loadUserByUsername(getUserPk(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    // 토큰에서 회원 정보 추출
    fun getUserPk(token: String?): String? {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject()
    }

    // Request의 Header에서 token 값을 가져옵니다. "Authorization" : "TOKEN값"
    fun resolveToken(request: HttpServletRequest): String? {
        return request.getHeader("Authorization")
    }

    // 토큰의 유효성 + 만료일자 확인
    fun validateToken(jwtToken: String?): Boolean {
        return try {
            val claims: Jws<Claims> = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken)
            !claims.getBody().getExpiration().before(Date())
        } catch (e: Exception) {
            false
        }
    }
}