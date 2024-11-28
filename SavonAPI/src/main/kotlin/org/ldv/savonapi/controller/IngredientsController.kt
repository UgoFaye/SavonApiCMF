package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.IngredientsDAO
import org.ldv.savonapi.model.entity.Ingredients
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
@RequestMapping("/api-savon/v1/ingredients")
class IngredientsController (val ingredientsDAO: IngredientsDAO) {
    @GetMapping
    fun getAllIngredients(): List<Ingredients> {
        return ingredientsDAO.findAll()
    }

    @GetMapping("/{id}")
    fun getIngredientsById(@PathVariable id: Long): ResponseEntity<Ingredients> {
        val ingredients = ingredientsDAO.findById(id)
        return if (ingredients.isPresent) {
            ResponseEntity.ok(ingredients.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createIngredients(@RequestBody ingredients:Ingredients): ResponseEntity<Ingredients> {
        val savedIngredients = ingredientsDAO.save(ingredients)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredients)
    }

    @PutMapping("/{id}")
    fun updateIngredients(@PathVariable id: Long, @RequestBody ingredients: Ingredients): ResponseEntity<Ingredients> {
        return  if (ingredientsDAO.existsById(id)) {
            ingredients.id = id
            val updateIngredients = ingredientsDAO.save(ingredients)
            ResponseEntity.ok(updateIngredients)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteIngredients(@PathVariable id : Long): ResponseEntity<Void> {
        return if (ingredientsDAO.existsById(id)) {
            ingredientsDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }else {
            ResponseEntity.notFound().build()
        }
    }
}