
package org.ldv.savonapi.service
import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientsDAO
import org.ldv.savonapi.model.dao.MentionDAO
import org.ldv.savonapi.model.entity.Caracteristique
import org.ldv.savonapi.model.entity.Ingredients
import org.ldv.savonapi.model.entity.Mention
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer (val mentionDAO: MentionDAO, val ingredientDAO: IngredientsDAO, val caracteristiqueDAO: CaracteristiqueDAO) : CommandLineRunner {
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
            var douceur = Caracteristique(nom = "douceur")
            var lavant = Caracteristique(nom = "lavant")
            var volMousse = Caracteristique(nom = "volMousse")
            var tenueMousse = Caracteristique(nom = "tenueMousse")
            var durete = Caracteristique(nom = "durete")
            var solubilite = Caracteristique(nom = "solubilite")
            var sechage = Caracteristique(nom = "sechage")

            caracteristiqueDAO.saveAll(listOf(douceur, lavant, volMousse, tenueMousse, durete, solubilite, sechage))

            var mentionDouceur1 = Mention(texte = "faible", caracteristique = douceur, scoreMin = 0f, scoreMax = 5f)
            var mentionDouceur2 = Mention(texte = "moyen", caracteristique = douceur, scoreMin = 5f, scoreMax = 10f)
            var mentionDouceur3 = Mention(texte = "fort", caracteristique = douceur, scoreMin = 10f, scoreMax = 15f)

            var mentionLavant1 = Mention(texte = "faible", caracteristique = lavant, scoreMin = 0f, scoreMax = 5f)
            var mentionLavant2 = Mention(texte = "moyen", caracteristique = lavant, scoreMin = 5f, scoreMax = 10f)
            var mentionLavant3 = Mention(texte = "fort", caracteristique = lavant, scoreMin = 10f, scoreMax = 15f)

            var mentionVolMousse1 = Mention(texte = "faible", caracteristique = volMousse, scoreMin = 0f, scoreMax = 5f)
            var mentionVolMousse2 = Mention(texte = "moyen", caracteristique = volMousse, scoreMin = 5f, scoreMax = 10f)
            var mentionVolMousse3 = Mention(texte = "fort", caracteristique = volMousse, scoreMin = 10f, scoreMax = 15f)

            var mentionTenueMousse1 = Mention(texte = "faible", caracteristique = tenueMousse, scoreMin = 0f, scoreMax = 5f)
            var mentionTenueMousse2 = Mention(texte = "moyen", caracteristique = tenueMousse, scoreMin = 5f, scoreMax = 10f)
            var mentionTenueMousse3 = Mention(texte = "fort", caracteristique = tenueMousse, scoreMin = 10f, scoreMax = 15f)

            var mentionDurete1 = Mention(texte = "faible", caracteristique = durete, scoreMin = 0f, scoreMax = 5f)
            var mentionDurete2 = Mention(texte = "moyen", caracteristique = durete, scoreMin = 5f, scoreMax = 10f)
            var mentionDurete3 = Mention(texte = "fort", caracteristique = durete, scoreMin = 10f, scoreMax = 15f)

            var mentionSolubilite1 = Mention(texte = "faible", caracteristique = solubilite, scoreMin = 0f, scoreMax = 5f)
            var mentionSolubilite2 = Mention(texte = "moyen", caracteristique = solubilite, scoreMin = 5f, scoreMax = 10f)
            var mentionSolubilite3 = Mention(texte = "fort", caracteristique = solubilite, scoreMin = 10f, scoreMax = 15f)

            var mentionSechage1 = Mention(texte = "faible", caracteristique = sechage, scoreMin = 0f, scoreMax = 5f)
            var mentionSechage2 = Mention(texte = "moyen", caracteristique = sechage, scoreMin = 5f, scoreMax = 10f)
            var mentionSechage3 = Mention(texte = "fort", caracteristique = sechage, scoreMin = 10f, scoreMax = 15f)

            mentionDAO.saveAll(listOf(mentionDouceur1, mentionDouceur2, mentionDouceur3, mentionLavant1, mentionLavant2, mentionLavant3,
                mentionVolMousse1, mentionVolMousse2, mentionVolMousse3, mentionTenueMousse1, mentionTenueMousse2, mentionTenueMousse3,
                mentionDurete1, mentionDurete2, mentionDurete3, mentionSolubilite1, mentionSolubilite2, mentionSolubilite3,
                mentionSechage1, mentionSechage2, mentionSechage3))
        }

    }
}
