package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.springframework.context.annotation.Description
import javax.management.Descriptor

@Entity
class Recettes (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id : Long? = null,
    var nom : String? = null,
    var description: String? = null,
    var typeAlcalin : String? = null,
    var quantiteAlcalin : Float = 0.0f,
    var concentrationAlcalin : Float? = null,
    var quantiteEau : Float? = null,
    var surgraissage : Float? = null,
    var avecSoude: Boolean? = null,
    var apportEau : Float? = null,


    @OneToMany(mappedBy = "LigneIngredients")
    var ligneIngredients: MutableList<LigneIngredients>,

    @OneToMany(mappedBy = "recette")
    var quantites: MutableList<Quantite> = mutableListOf(),

    @OneToMany(mappedBy = "recette")
    var resultats: MutableList<Resultat> = mutableListOf()
)
{
    fun calculQteAlcalin() {
        var qteAlcalinNormal = 0.0

        if (avecSoude == true) {
            qteAlcalinNormal = this.ligneIngredients.sumOf { this.quantiteAlcalin * it.ingredients!!.sapo.toDouble() * (40.0 / 56 / 1000) }
        }
        else {
            qteAlcalinNormal = this.ligneIngredients.sumOf { (this.quantiteAlcalin * it.ingredients!!.sapo.toDouble()) / 1000.0 }
        }

        quantiteAlcalin = qteAlcalinNormal.toFloat() / (concentrationAlcalin!! / 100)
        quantiteAlcalin -= (quantiteAlcalin * (surgraissage!! / 100))
        quantiteAlcalin = this.quantiteAlcalin.toFloat()
    }

    fun calculApportEau() {
        var concentrationEau = (100 - concentrationAlcalin!!) / 100
        var apportEau = quantiteAlcalin * concentrationEau
        this.apportEau = apportEau
    }

    fun calculNonPondere() {
        var ins = this.ligneIngredients.sumOf {it.ingredients!!.ins!! * it.pourcentage/100.0}
        var iode = this.ligneIngredients.sumOf {it.ingredients!!.iode!! * it.pourcentage / 100.0}

        for (unResultat in this.resultats){
            if(unResultat.caracteristique!!.nom=="ins"){
                unResultat.score=ins.toFloat()
            }else if(unResultat.caracteristique!!.nom=="iode")
                unResultat.score=iode.toFloat()
        }

        this.resultats.find { it.caracteristique!!.nom=="ins" }!!.score=ins.toFloat()
    }

    fun calculScorePondere() {
        var douceur = this.ligneIngredients.sumOf { it.ingredients!!.douceur!! * it.pourcentage / 100.0 }
        var lavant = this.ligneIngredients.sumOf { it.ingredients!!.lavant!! * it.pourcentage / 100.0 }
        var volMousse = this.ligneIngredients.sumOf { it.ingredients!!.volMousse!! * it.pourcentage / 100.0 }
        var tenueMousse = this.ligneIngredients.sumOf { it.ingredients!!.tenueMousse!! * it.pourcentage / 100.0 }
        var durete = this.ligneIngredients.sumOf { it.ingredients!!.durete!! * it.pourcentage / 100.0 }
        var solubilite = this.ligneIngredients.sumOf { it.ingredients!!.solubilite!! * it.pourcentage / 100.0 }
        var sechage = this.ligneIngredients.sumOf { it.ingredients!!.sechage!! * it.pourcentage / 100.0 }

        douceur = douceur * (1 + 0.01494 * this.surgraissage!!)
        lavant = lavant * (1 + (-0.01203) * this.surgraissage!!)
        volMousse = volMousse * (1 + (-0.00702) * this.surgraissage!!)
        tenueMousse = tenueMousse * (1 + 0.01016 * this.surgraissage!!)
        durete = durete * (1 + (-0.00602) * this.surgraissage!!)
        solubilite = solubilite * (1 + 0.00250 * this.surgraissage!!)
        sechage = sechage * (1 + (-0.00503) * this.surgraissage!!)

        this.resultats.find { it.caracteristique!!.nom == "douceur" }!!.score = douceur.toFloat()
        this.resultats.find { it.caracteristique!!.nom == "lavant" }!!.score = lavant.toFloat()
        this.resultats.find { it.caracteristique!!.nom == "volMousse" }!!.score = volMousse.toFloat()
        this.resultats.find { it.caracteristique!!.nom == "tenueMousse" }!!.score = tenueMousse.toFloat()
        this.resultats.find { it.caracteristique!!.nom == "durete" }!!.score = durete.toFloat()
        this.resultats.find { it.caracteristique!!.nom == "solubilite" }!!.score = solubilite.toFloat()
        this.resultats.find { it.caracteristique!!.nom == "sechage" }!!.score = sechage.toFloat()

    }
}
