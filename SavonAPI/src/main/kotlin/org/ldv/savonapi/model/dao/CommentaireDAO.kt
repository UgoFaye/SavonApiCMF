package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Commentaire
import org.springframework.data.jpa.repository.JpaRepository

interface CommentaireDAO : JpaRepository<Commentaire, Long> {
}