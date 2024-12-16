package org.ldv.savonapi.dto

class RecetteFormDTO (
    var id: Long? = null,
    var nom: String,
    var description: String,
    var surgraissage: Float,
    var avecSoude: Boolean,
    var concentrationAlcalin: Float,
    var ligneIngredients: MutableList<LigneIngredientDTO> = mutableListOf()
) {
}