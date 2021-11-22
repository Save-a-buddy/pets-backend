package com.ae.petapi.config.security

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
