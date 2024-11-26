package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Ingredients
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientsDAO : JpaRepository<Ingredients, Long> {
}