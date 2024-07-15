package com.example.mod2demo1

fun main() {

    //boucle foreach
    val customMonList = mutableListOf("OrangiMon", "ComeMon", "CarMon", "CardaMon")
    for(customWord in customMonList){
        println(customWord)
    }

    for((key, value) in customMonList.withIndex()){
        println("$key = $value")
    }

    println("--------------")

    // boucle for
    for(i in 1..10){
        println("i = $i")
    }
    println("--------------")
    for(i in 10 downTo 1 step 2){
        println("i = $i")
    }

    //un prédicat (callback) se met toujours
    // en dernier paramètre en dehors de la fonction
    val list = List(30) {
        index -> "Item $index"
    }

    for(item in list){
        println(item)
    }

}
