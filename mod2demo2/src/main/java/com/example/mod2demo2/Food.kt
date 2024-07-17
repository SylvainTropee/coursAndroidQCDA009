package com.example.mod2demo2

interface Eatable {
    var isEdible: Boolean
    fun eat() {
        println("Miam !")
    }

    fun truc() : String
}

class Mushroom(val name : String, override var isEdible: Boolean) : Eatable{
    override fun eat() {
        if(this.isEdible){
            super.eat()
        }else{
            println("Je plane/meurs !")
        }
    }

    override fun truc(): String {
        TODO("Not yet implemented")
    }
}

fun main() {
    val toad = Mushroom(name = "Bolet", isEdible = true)
    val toad2 = Mushroom(name = "Ammanite tue-mouche", isEdible = false)

    toad.eat()
    toad2.eat()
}