package com.ae.pet.entity.pet.repository

import com.ae.pet.entity.pet.entity.PetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<PetEntity, Long> {

}