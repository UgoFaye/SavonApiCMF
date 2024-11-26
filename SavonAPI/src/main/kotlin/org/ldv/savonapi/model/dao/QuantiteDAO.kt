package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Quantite
import org.springframework.data.jpa.repository.JpaRepository

interface QuantiteDAO : JpaRepository<Quantite, Long> {
}