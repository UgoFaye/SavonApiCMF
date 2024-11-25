package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity

class Ingredients (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var nom: String? = null,
    var sapo : Float? = null,
    var iode : Float? = null,
    var douceur: Float? = null,
    var lavant: Float? = null,
    var volMousse: Float? = null,
    var tenueMousse: Float? = null,
    var durete: Float? = null,
    var solubilite: Float? = null,
    var sechage: Float? = null,

   @ManyToMany
   @JoinTable(
       name = "ingredients_recettes",
       joinColumns = [JoinColumn(name = "ingredients_id")],
       inverseJoinColumns = [JoinColumn(name = "recettes_id")]
   )
   var recettes: MutableList<Recettes> = mutableListOf()
)
{}