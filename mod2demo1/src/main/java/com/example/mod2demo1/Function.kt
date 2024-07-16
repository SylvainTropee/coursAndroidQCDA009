package com.example.mod2demo1

//fonction d'extension
//fun String.sayHello(){
//    println("Hello $this")
//}
//
//fun main() {
//    "Sylvain".sayHello()
//}

//elvis operator
//fun main() {
//
//    var name : String? = null
//
//    //?. teste si null, ?: donne une valeur par défaut si null
//    val length = name?.length ?: -1
//    println(length)
//}

fun main() {

    val colors = mutableListOf("jaune", "rouge", "vert", "bleu", "cyan", "grenat", "caramel")

    colors.add("rose")
    colors += "violet"
    colors += "violet"

    val nbPurple = colors.filter { color ->
        color == "violet"
    }.count()

    val nbPurple2 = colors.filter {
        it == "violet"
    }.count()

    print(nbPurple)

    


}











