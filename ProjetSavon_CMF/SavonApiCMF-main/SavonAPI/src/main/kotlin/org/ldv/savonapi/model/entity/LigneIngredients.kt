package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity

class LigneIngredients (
   @EmbeddedId
   var ligneIngredientsId: LigneIngredientsId? = null,


   @MapsId("ingredientsId")
   @ManyToOne
   @JoinColumn(name = "ingredients_id")
   var ingredients: Ingredients? = null,

   @MapsId("recettesId")
   @ManyToOne
   @JoinColumn(name = "recettes_id")
   var recettes: Recettes? = null,

   var qte : Float,
   var pourcentage:Float

)

{}