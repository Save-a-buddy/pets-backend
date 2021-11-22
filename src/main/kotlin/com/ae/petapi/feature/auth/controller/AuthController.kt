package com.ae.petapi.feature.auth.controller

import com.ae.petapi.config.security.generateToken
import com.ae.petapi.dto.AuthenticationRequest
import com.ae.petapi.dto.AuthenticationResponse
import com.ae.petapi.feature.auth.service.UserDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    @Autowired private val authenticationManager: AuthenticationManager,
    @Autowired private val userDetailService: UserDetailService
) {

    @PostMapping("/authenticate")
    fun createToken(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return try {
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    request.username,
                    request.password
                ))
            val userDetails = userDetailService.loadUserByUsername(request.username)
            val jwt = generateToken(userDetails)

            ResponseEntity(AuthenticationResponse(jwt), HttpStatus.OK)
        } catch (e: BadCredentialsException) {
            e.stackTrace
            ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }

}