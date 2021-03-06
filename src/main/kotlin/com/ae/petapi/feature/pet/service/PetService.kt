package com.ae.petapi.feature.pet.service

import com.ae.petapi.entity.PetEntity

interface PetService {

    fun getAllPets(): List<PetEntity>

    fun getPetById(id: Long): PetEntity

    fun savePet(pet: PetEntity): PetEntity

    fun updatePet(pet: PetEntity): PetEntity

    fun deletePet(pet: PetEntity)

}