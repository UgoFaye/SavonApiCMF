package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.entity.Caracteristique
import org.ldv.savonapi.model.entity.resultatId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api-savon/v1/caracteristique")
class CaracteristiqueController(private val caracteristiqueDAO: CaracteristiqueDAO) {
    @GetMapping
    fun getAllCaracteristique(): List<Caracteristique> {
        return caracteristiqueDAO.findAll()
    }

    @GetMapping("/{id}")
    fun getCaracteristiqueById(@PathVariable id: Long): ResponseEntity<Caracteristique> {
        val caracteristique = caracteristiqueDAO.findById(id)
        return if (caracteristique.isPresent) {
            ResponseEntity.ok(caracteristique.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createCaracteristique(@RequestBody caracteristique: Caracteristique): ResponseEntity<Caracteristique> {
        val savedCaracteristique = caracteristiqueDAO.save(caracteristique)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCaracteristique)
    }

    @PutMapping("/{id}")
    fun updateCaracteristique(@PathVariable id: Long, @RequestBody caracteristique: Caracteristique): ResponseEntity<Caracteristique> {
        return if (caracteristiqueDAO.existsById(id)) {
            caracteristique.id = id
            val updateCaracteristique = caracteristiqueDAO.save(caracteristique)
            ResponseEntity.ok(updateCaracteristique)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCaracteristique(@PathVariable id: Long): ResponseEntity<Void> {
        return if (caracteristiqueDAO.existsById(id)) {
            caracteristiqueDAO.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

}