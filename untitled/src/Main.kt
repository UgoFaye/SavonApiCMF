@startuml
left to right direction

actor Utilisateur_inscrit
actor Visiteur

rectangle Système {

    ' Cas d'utilisation pour tous les acteurs
            Visiteur --> (Connection / Inscription / Modification MdP)
    Visiteur --> (Consulter la Politique de Confidentialité)

    ' Cas d'utilisation pour l'utilisateur inscrit
    Utilisateur_inscrit --> (Recherche)
    Utilisateur_inscrit --> (Enregistrer une recette CRUD)
    Utilisateur_inscrit --> (Matière CRUD)
    Utilisateur_inscrit --> (Simuler / calculer le score du savon)
    Utilisateur_inscrit --> (Commentaire / Note)

    ' Cas d'utilisation pour le gestionnaire
    (Gérer les utilisateurs du site) <-- Gestionnaire

    ' Cas d'utilisation pour l'administrateur
    (Gérer les utilisateurs du site) <-- Admin
    (Enregistrer une recette CRUD) <-- Admin
    (Matière CRUD) <-- Admin

}


@enduml
