package org.ldv.savonapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
//TODO Les Imports suivant sont à adapter selon votre projet
import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientsDAO
import org.ldv.savonapi.model.entity.*
import org.ldv.savonapi.service.DataInitializer

@SpringBootTest
class RecetteTests(
    @Autowired val dataInitializer: DataInitializer,
    @Autowired val ingredientsDAO: IngredientsDAO,
    @Autowired val caracteristique: Caracteristique
)
{
    @Autowired
    private lateinit var caracteristiqueDAO: CaracteristiqueDAO
    private lateinit var savon: Recettes

    @BeforeEach
    fun setup() {
        dataInitializer.run()
        //TODO : Vérifier les id des ingredients et caracteristiques dans le dataInitializer
        val huileCoco = ingredientsDAO.findById(1).get()
        val huileOlive = ingredientsDAO.findById(2).get()

        val iode = caracteristiqueDAO.findById(1).get()
        val ins = caracteristiqueDAO.findById(2).get()
        val douceur = caracteristiqueDAO.findById(3).get()
        val lavant = caracteristiqueDAO.findById(4).get()
        val volMousse = caracteristiqueDAO.findById(5).get()
        val tenueMousse = caracteristiqueDAO.findById(6).get()
        val durete = caracteristiqueDAO.findById(7).get()
        val solubilite = caracteristiqueDAO.findById(8).get()
        val sechage = caracteristiqueDAO.findById(9).get()

        // Initialisation du savon avec les données fournies
        savon = Recettes(
            id = 1,
            nom = "Savon Hydratant Reduction",
            description = "Un savon doux et hydratant pour la peau sensible.",
            surgraissage = 5f,
            apportEau = 353.0833f,
            avecSoude = true,
            concentrationAlcalin = 30f,
            quantiteAlcalin = 504.40475f,
            ligneIngredients = mutableListOf(
                LigneIngredients(
                    LigneIngredientsId(ingredientsId = 1, recetteId = 1),
                    qte = 500f,
                    pourcentage = 50f,
                    ingredients = huileOlive
                ),
                LigneIngredients(
                    LigneIngredientsId(ingredientsId = 2, recetteId = 1),
                    qte = 500f,
                    pourcentage = 50f,
                    ingredients = huileCoco
                )
            ),
            resultats = mutableListOf(
                Resultat(resultat_id = (1, 1), score = 0f, caracteristique = iode),
                Resultat(resultat_id = (2, 1), score = 0f, caracteristique = ins),
                Resultat(resultat_id = (3, 1), score = 0f, caracteristique = douceur),
                Resultat(resultat_id = (4, 1), score = 0f, caracteristique = lavant),
                Resultat(resultat_id = (5, 1), score = 0f, caracteristique = volMousse),
                Resultat(resultat_id = (6, 1), score = 0f, caracteristique = tenueMousse),
                Resultat(resultat_id = (7, 1), score = 0f, caracteristique = durete),
                Resultat(resultat_id = (8, 1), score = 0f, caracteristique = solubilite),
                Resultat(resultat_id = (9, 1), score = 0f, caracteristique = sechage),
            )
        )
    }
}

