package com.example.mod2demo1

//utilisation du if
//fun main() {
//    println("Saisssez votre age : ")
//    //readLn() permet la saisie
//    val age : Int = readln().toInt()
//
//    val message = if(age >= 18) {
//        "Majeur !"
//    }else{
//        "Mineur !"
//    }
//
//    println(message)
//}

//utilisation du when
fun main() {
    var age = readln().toInt()

    when(age){
        1,2 -> println("C'est un bébé !")
        in 3..18 -> println("C'est un enfant !")
        is Int -> println("C'est un adulte !")
        else -> println("C'est autre chose")
    }
}











