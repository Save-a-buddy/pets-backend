package com.ae.petapi.feature.auth.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailService : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return User("AE", "{noop}12345", arrayListOf())
    }
}