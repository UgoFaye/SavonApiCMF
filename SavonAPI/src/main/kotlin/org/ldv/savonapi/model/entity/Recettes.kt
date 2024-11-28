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

    @OneToMany(mappedBy = "recette")
    var quantites: MutableList<Quantite> = mutableListOf(),

    @OneToMany(mappedBy = "recette")
    var resultats: MutableList<Resultat> = mutableListOf()
)
{}
