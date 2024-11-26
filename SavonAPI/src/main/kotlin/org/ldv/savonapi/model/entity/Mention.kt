package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Mention (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var texte: String? = null,
    var scoreMin: Float? = null,
    var scoreMax: Float? = null,

    @ManyToOne
    @JoinColumn(name = "caracteristique_id")
    var caracteristique: Caracteristique? = null
) {
}