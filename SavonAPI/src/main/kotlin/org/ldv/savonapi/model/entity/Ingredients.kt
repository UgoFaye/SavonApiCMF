package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Ingredients (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    var id: Long? = null,
    var nom: String? = null,
    var sapo : Float? = null,
    var iode : Float? = null,
    var ins : Float? = null,
    var douceur: Float? = null,
    var lavant: Float? = null,
    var volMousse: Float? = null,
    var tenueMousse: Float? = null,
    var durete: Float? = null,
    var solubilite: Float? = null,
    var sechage: Float? = null,
    @OneToMany(mappedBy = "ingredient", cascade = [CascadeType.REMOVE], orphanRemoval = true)
    var quantites: MutableList<Quantite> = mutableListOf()

) {


}