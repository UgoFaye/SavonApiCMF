package org.ldv.savonapi.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

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
    var sechage: Float? = null
    )
{}