package org.ldv.savonapi.model.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import java.io.Serializable

@Embeddable

class LigneIngredientsId (

    val ingredientsId: Long,
    val recetteId: Long
) : Serializable

{
}