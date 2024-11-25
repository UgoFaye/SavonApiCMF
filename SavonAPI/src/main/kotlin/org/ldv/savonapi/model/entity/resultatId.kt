package org.ldv.savonapi.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class resultatId (
    val recettes_id: Long,
    val caracteristique_id: Long
) : Serializable
{}