package com.ae.pet.dto


data class PetDto(
    val id: Long,
    val name: String = "",
    val age: Int? = null,
    val owner: PersonDto? = null
)
