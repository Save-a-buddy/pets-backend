package com.ae.pet.entity

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "person")
data class PersonEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "name")
    var name: String = "",
    @JsonProperty("last_name")
    @Column(name = "last_name")
    var lastName: String = "",
    @Column(name = "img_url")
    var imgUrl: String? = "",
    @Column(name = "Address")
    var address: String? = null
)
