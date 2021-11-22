package com.ae.petapi.dto

data class PersonDto(
    val id: Long,
    val name: String = "",
    val lastName: String = "",
    val imgUrl: String? = "",
    val address: String? = null
)
