package org.ldv.savonapi.dto

import org.ldv.savonapi.model.entity.LigneIngredientsId

class LigneIngredientDTO (
    var ingredientsId: Long,
    var recetteId: Long?,
    var quantite: Float,
    var pourcentage: Float
) {
}