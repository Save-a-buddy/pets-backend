package com.ae.petapi.config.security.filter

import com.ae.petapi.config.security.extractUsername
import com.ae.petapi.config.security.validateToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JWTFilterRequest(
    @Autowired private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader("Authorization")
        if (!authorizationHeader.isNullOrEmpty() && authorizationHeader.startsWith("Bearer")) {
            val jwt = authorizationHeader.substring(7)
            val username = extractUsername(jwt)

            if (!username.isNullOrBlank() && SecurityContextHolder.getContext().authentication == null) {
                val userDetail = userDetailsService.loadUserByUsername(username)

                if (validateToken(jwt, userDetail)) {
                    val authToken = UsernamePasswordAuthenticationToken(
                        userDetail,
                        null,
                        userDetail.authorities)

                    authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                    SecurityContextHolder.getContext().authentication = authToken
                }
            }
        }

        filterChain.doFilter(request, response)
    }

}