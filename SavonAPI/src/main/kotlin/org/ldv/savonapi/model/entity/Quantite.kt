package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Quantite (
    @EmbeddedId
    var quantite_id: quantiteId? = null,

    var quantite: Float? = null,
    var pourcentages: Float? = null,

    @MapsId("ingredients_id")
    @ManyToOne
    @JoinColumn(name = "ingredients_id")
    var ingredient: Ingredients? = null,

    @MapsId("recettes_id")
    @ManyToOne
    @JoinColumn(name = "recettes_id")
    var recette: Recettes? = null
) {
}