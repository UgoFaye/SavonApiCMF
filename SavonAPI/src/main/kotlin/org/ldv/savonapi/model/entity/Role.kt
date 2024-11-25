package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import java.sql.Date

@Entity
class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null,
    var nom: String? = null,

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null
){
}