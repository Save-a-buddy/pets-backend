package com.ae.pet.entity.pet.entity

import javax.persistence.*


@Entity
@Table(name = "pets")
data class PetEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "name")
    var name: String = "",
    @Column(name = "age")
    var age: Int = 0
)