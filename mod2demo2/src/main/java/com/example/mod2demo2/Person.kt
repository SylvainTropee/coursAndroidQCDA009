package com.example.mod2demo2

open class Person(var name: String, var age: Int) {
    fun displayInfo(): String {
        return "Mon nom est  $name, j'ai $age  ans";
    }

    open fun likeToEat(): String {
        return "J'aime manger les enfants"
    }
}

class Child(name: String, age: Int, var schoolLevel: String) :
    Person(name, age) {

    override fun likeToEat(): String {
        return "J'aime manger mes crottes de nez !"
    }

}


fun main() {

    val p = Person(age = 12, name = "Michel")
    val c = Child(age = 8, name = "Toto", schoolLevel = "CE2")

    println(p.displayInfo())
    println(p.likeToEat())
    println(c.displayInfo())
    println(c.likeToEat())

}