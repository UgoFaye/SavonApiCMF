
package org.ldv.savonapi.service
import org.ldv.savonapi.model.dao.CaracteritiqueDAO
import org.ldv.savonapi.model.dao.IngredientsDAO
import org.ldv.savonapi.model.entity.Ingredients
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
@Component
class DataInitializer (val ingredientDAO: IngredientsDAO, val caracteristiqueDAO: CaracteritiqueDAO) : CommandLineRunner {
    override fun run(vararg args: String?) {
        //Pour importer les ingredients 
        if (ingredientDAO.count() == 0L) { // Éviter les doublons
            var huileOlive=  Ingredients(1,"Huile d'olive",189f,78f,111f,9.260f,10.192f,9.838f,9.152f,10.144f,9.298f,10.194f)
            var huileCoco= Ingredients(2,"Huile Coco", 257f,9f,248f,7.746f,14.462f,13.326f,9.560f,9.390f,11.204f,11.880f)
            var ingredients= listOf<Ingredients>(huileOlive,huileCoco)
            ingredientDAO.saveAll(ingredients)
        }
        // Pour importer les caracteristiques ...
        if (caracteristiqueDAO.count() == 0L) {
            
        }

    }
}
