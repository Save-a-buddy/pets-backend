package com.ae.pet.entity.pet.service

import com.ae.pet.entity.pet.entity.PetEntity

interface PetService {

    fun getAllPets(): List<PetEntity>

    fun getPetById(id: Long): PetEntity

    fun savePet(pet: PetEntity): PetEntity

    fun updatePet(pet: PetEntity): PetEntity

    fun deletePet(pet: PetEntity)

}