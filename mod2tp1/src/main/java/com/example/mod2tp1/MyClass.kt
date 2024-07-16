package com.example.mod2tp1

fun main() {

    val movies = mutableMapOf<String, Boolean>()
    var userChoice: Int?

    do {

        //afficher le menu
        displayMenu()
        //récupérer le choix utilisateur
        userChoice = getUserChoice()
        //faire les trucs en fonction du choix
        when (userChoice) {
            1 -> {
                val movie = getMovieTitle()
                movies[movie] = true
            }

            2 -> movies[getMovieTitle()] = false

            3 -> {
                movies.forEach { (s, b) ->
                    println("$s : " + if (b) "Vu" else "Pas vu")
                }
            }

            4 -> println("Bye bye !")
            else -> println("Choix incorrect !")
        }

    }while (userChoice != 4)

}

fun getUserChoice(): Int? {
    return readlnOrNull()?.toIntOrNull()
}

fun getMovieTitle(): String {
    println("Saisir film/série : ")
    val movie = readlnOrNull()
    return movie ?: ""
}


fun displayMenu() {
    println("Choisissez une option : ")
    println("1 - Ajouter un film/série déjà vu")
    println("2 - Ajouter un film/série pas vu")
    println("3 - Voir toute la liste")
    println("4 - Arrêter le programme")
}










