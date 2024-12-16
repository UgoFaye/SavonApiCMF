package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import java.sql.Date

@Entity
class Commentaire (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var texte: String? = null,
    var date: Date? = null,

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null
) {
}