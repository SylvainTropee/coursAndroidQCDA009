package com.example.mod4demo4

class HorseRepository {

    private val horses = listOf("Etalon noir", "Grand Galop", "Galopin", "My Little Poney")

    fun getHorses(): List<String> {
        return horses
    }

}