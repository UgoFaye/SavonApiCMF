package org.ldv.savonapi.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class quantiteId (
    val ingredients_id: Long,
    val recettes_id: Long
) : Serializable
{}