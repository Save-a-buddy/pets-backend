package com.ae.petapi.config.security

import com.ae.petapi.feature.auth.service.UserDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig(
    @Autowired private val userDetailService: UserDetailService
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailService) //service to receive user from database or service like firebase or oauth0
    }

    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()?.authorizeRequests()?.antMatchers("/**/authenticate")?.permitAll()
            ?.anyRequest()?.authenticated()
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}