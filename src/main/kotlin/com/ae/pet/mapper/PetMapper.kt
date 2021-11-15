package com.ae.pet.mapper

import com.ae.pet.dto.PersonDto
import com.ae.pet.dto.PetDto
import com.ae.pet.entity.PersonEntity
import com.ae.pet.entity.PetEntity


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