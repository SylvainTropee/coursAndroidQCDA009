package com.example.mod6demo2

class CakeRepository(private val cakeDAO: CakeDAO) {

    fun insert(cake: Cake): Long {
        return cakeDAO.insertCake(cake)
    }

    fun findAll(): List<Cake> {
        return cakeDAO.findAllCakes()
    }

}