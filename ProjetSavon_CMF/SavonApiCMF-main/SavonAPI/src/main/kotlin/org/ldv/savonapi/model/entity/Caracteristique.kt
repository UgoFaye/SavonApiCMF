package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Caracteristique (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var nom: String? = null,
    var sapo : Float? = null,
    var iode : Float? = null,
    var ins : Float? = null,
    var douceur: Float? = null,
    var lavant: Float? = null,
    var volMousse: Float? = null,
    var tenueMousse: Float? = null,
    var durete: Float? = null,
    var solubilite: Float? = null,
    var sechage: Float? = null,

    @OneToMany(mappedBy = "caracteristique")
    var resultats: MutableList<Resultat> = mutableListOf()
) {
}