package com.ae.petapi.mapper

import com.ae.petapi.dto.PersonDto
import com.ae.petapi.dto.PetDto
import com.ae.petapi.entity.PersonEntity
import com.ae.petapi.entity.PetEntity


fun PetDto.toPetEntity() = PetEntity(
    id = id,
    name = name,
    age = age,
    owner = owner?.toPersonEntity()
)

fun PersonDto.toPersonEntity() = PersonEntity(
    id = id,
    name = name,
    lastName = lastName,
    imgUrl = imgUrl,
    address = address
)

fun PetEntity.toPetDto() = PetDto(
    id = id,
    name = name,
    age = age,
    owner = owner?.toPersonDto()
)

fun PersonEntity.toPersonDto() = PersonDto(
    id = id,
    name = name,
    lastName = lastName,
    imgUrl = imgUrl,
    address = address
)