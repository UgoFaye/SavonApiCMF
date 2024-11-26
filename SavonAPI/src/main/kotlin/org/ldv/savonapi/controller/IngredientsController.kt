package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.IngredientsDAO
import org.ldv.savonapi.model.entity.Ingredients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api-savon/v1/ingredients")
class IngredientsController {

    @GetMapping
    fun getAllExemples(): List<Ingredients> {
        return IngredientsDAO.findall()
    }
}