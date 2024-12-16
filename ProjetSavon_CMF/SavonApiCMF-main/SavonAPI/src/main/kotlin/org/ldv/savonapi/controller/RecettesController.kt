package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.RecettesDAO
import org.ldv.savonapi.model.entity.Recettes
import org.ldv.savonapi.service.SimulateurService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@CrossOrigin
@RestController
@RequestMapping("/api-savon/v1/recettes")
class RecettesController(private val recettesDAO: RecettesDAO, val simulateurService: SimulateurService) {
    @GetMapping
    fun getAllRecettes(): List<Recettes> {
        return recettesDAO.findAll()
    }

    @GetMapping("/{id}")
    fun getRecetteById(@PathVariable id: Long): ResponseEntity<Recettes> {
        val recettes = recettesDAO.findById(id)
        return if (recettes.isPresent) {
            ResponseEntity.ok(recettes.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createRecettes(@RequestBody recettes: Recettes): ResponseEntity<Recettes> {
        val savedRecettes = recettesDAO.save(recettes)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecettes)
    }

    @PutMapping("/{id}")
    fun updateRecettes(@PathVariable id: Long, @RequestBody recettes: Recettes): ResponseEntity<Recettes> {
        return  if (recettesDAO.existsById(id)) {
            recettes.id = id
            val updateRecettes = recettesDAO.save(recettes)
            ResponseEntity.ok(updateRecettes)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @DeleteMapping("/{id}")
    fun deleteRecettes(@PathVariable id : Long): ResponseEntity<Void> {
        return if (recettesDAO.existsById(id)) {
            recettesDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }else {
            ResponseEntity.notFound().build()
        }
    }

}