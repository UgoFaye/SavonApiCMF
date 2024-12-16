package org.ldv.savonapi.service

import org.ldv.savonapi.model.dao.*
import org.springframework.stereotype.Component

@Component
class SimulateurService (
    var caracteristiqueDAO: CaracteristiqueDAO,
    var recettesDAO: RecettesDAO,
    var ingredientsDAO: LigneIngredientsDAO,
    var ligneIngredientsDAO: LigneIngredientsDAO,
    var mentionDAO: MentionDAO,
    var resultatDAO: ResultatDAO
) {
}