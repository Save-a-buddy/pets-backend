package com.ae.petapi.config.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

const val KEY: String = "t3st"

fun generateToken(userDetail: UserDetails): String = Jwts.builder()
    .setSubject(userDetail.username)
    .setIssuedAt(Date())
    .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
    .signWith(SignatureAlgorithm.HS256, KEY)
    .compact()

fun validateToken(token: String, userDetail: UserDetails): Boolean {
    return userDetail.username.equals(extractUsername(token)) && !isTokenExpired(token)
}

fun isTokenExpired(token: String): Boolean = getClaims(token).expiration.before(Date())

fun extractUsername(token: String): String = getClaims(token).subject

private fun getClaims(token: String): Claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).body

