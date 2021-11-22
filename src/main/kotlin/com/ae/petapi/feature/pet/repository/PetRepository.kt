package com.ae.petapi.feature.pet.repository

import com.ae.petapi.entity.PetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<PetEntity, Long> {

}