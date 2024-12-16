@startuml
class Commentaire {
    +id : int
    +texte : String
    +date : Date
}

class Utilisateur {
    +id : int
    +motDePasse : String
    +adresseMail : String
}

class Role {
    +id : int
    +nom : String
}

class Recettes {
    +id : int
    +nom : String
    +typeAlcalinn : String
    +quantiteAlcalin: String
    +concentrationAlcalin : String
    +quantiteEau : String
    +surgraissage : float
}

class Quantite {
    +quantite : float
    +pourcentages : float
}

class Ingredients {
    +id : int
    +nom : String
    +Sapo: float
    +Iode: float
    +INS: float
    +Douceur: float
    +Lavant: float
    +vol mousse: float
    +tenue mousse: float
    +dureté: float
    +solubilité: float
    +sechage: float
}

class Resultat {
    +score : float
}

class Caracteristique {
    +id : int
    +nom : String
}

class Mention {
    +id : int
    +texte : String
    +scoreMin : float
    +scoreMax : float
}

Utilisateur "1" -- "0..*" Commentaire : ecrit
Utilisateur "0..*" -- "1" Role : appartient
Recettes "0..*" -- "1" Utilisateur : créé_par
Ingredients "*"--"*"  Recettes
(Ingredients, Recettes)..Quantite

Recettes "0..*" -- "0..*" Caracteristique
(Recettes, Caracteristique).. Resultat
Caracteristique "1" -- "0..*" Mention

@enduml
