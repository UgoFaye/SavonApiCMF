package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Resultat (
    @EmbeddedId
    var resultat_id: resultatId? = null,

    var score: Float? = null,

    @MapsId("caracteristique_id")
    @ManyToOne
    @JoinColumn(name = "caracteristiqueId")
    var caracteristique: Caracteristique? = null,

    @MapsId("recettes_id")
    @ManyToOne
    @JoinColumn(name = "recettes_id")
    var recettes: Recettes? = null
) {
}