package com.example.mod2demo2

class Base

class Sport(val name : String, val type : String, val nbPlayer : Int){

    var isIndoor : Boolean = false
        get() = field
        set(value) {
            field = value
        }

    fun displayMatch(): String {
        return "Le match de $name se déroulera le 12 Décembre";
    }

    //ajout de constructeur supplémentaire
    //constructor() : this()

}


fun main() {
    val b = Base()
    val basket = Sport("Basket", "Collectif", 5)
    basket.isIndoor = true
    println(basket.displayMatch())
}