package com.ae.pet.entity.pet.controller

import com.ae.pet.entity.pet.entity.PetEntity
import com.ae.pet.entity.pet.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pet")
class PetController(
    @Autowired val service: PetService
) {

    @GetMapping()
    fun getAllPets(): ResponseEntity<List<PetEntity>> {
        val pets = service.getAllPets()
        return ResponseEntity(pets, HttpStatus.OK)
    }

    @GetMapping(value = ["/{id}"])
    fun getPetById(@PathVariable id: Long): ResponseEntity<PetEntity> {
        val pet = service.getPetById(id)
        return ResponseEntity(pet, HttpStatus.OK)
    }

    @PostMapping
    fun savePet(@RequestBody pet: PetEntity): ResponseEntity<PetEntity> {
        val pet = service.savePet(pet)
        return ResponseEntity(pet, HttpStatus.OK)
    }

    fun updatePet(pet: PetEntity): ResponseEntity<PetEntity> {
        val pet = service.updatePet(pet)
        return ResponseEntity(pet, HttpStatus.OK)
    }

    fun deletePet(pet: PetEntity): ResponseEntity<String> {
        val pet = service.deletePet(pet)
        return ResponseEntity("", HttpStatus.OK)
    }

}