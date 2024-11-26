package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Recettes
import org.springframework.data.jpa.repository.JpaRepository

interface RecettesDAO : JpaRepository<Recettes, Long> {
}