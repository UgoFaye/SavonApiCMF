package org.ldv.savonapi.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Utilisateur (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var motdePasse: String? = null,
    var adresseMail: String? = null,

    @ManyToOne
    @JoinColumn (name = "recette_id")
    var recettes: Recettes? = null
){
}