package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import java.sql.Date

@Entity
class Caracteristique (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var nom: String? = null,

    @ManyToMany
    @JoinColumn(name = "recette_id")
    var recettes: Recettes? = null
) {
}