package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.LigneIngredients
import org.springframework.data.jpa.repository.JpaRepository

interface LigneIngredientsDAO : JpaRepository<LigneIngredients, Long> {
}