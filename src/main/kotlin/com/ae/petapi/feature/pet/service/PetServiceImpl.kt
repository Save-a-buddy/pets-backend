package com.ae.petapi.feature.pet.service

import com.ae.petapi.entity.PetEntity
import com.ae.petapi.feature.pet.repository.PetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PetServiceImpl(
    @Autowired val repository: PetRepository
) : PetService {

    override fun getAllPets(): List<PetEntity> = repository.findAll()

    override fun getPetById(id: Long): PetEntity = repository.findById(id).get()

    override fun savePet(pet: PetEntity): PetEntity = repository.save(pet)

    override fun updatePet(pet: PetEntity): PetEntity = repository.save(pet)

    override fun deletePet(pet: PetEntity) = repository.delete(pet)
}