package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity


class Recettes (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id : Long? = null,
    var nom : String? = null,
    var typeAlcalin : String? = null,
    var quantiteAlcalin : String? = null,
    var concentrationAlcalin : String? = null,
    var quantiteEau : String? = null,
    var surgraissage : Float? = null,

    @ManyToMany
    @JoinTable(
        name = "recettes_ingredients",
        joinColumns = [JoinColumn(name = "recettes_id")],
        inverseJoinColumns = [JoinColumn(name = "ingredients_id")]
    )
    var ingredients: MutableList<Ingredients> = mutableListOf()
)
{}
