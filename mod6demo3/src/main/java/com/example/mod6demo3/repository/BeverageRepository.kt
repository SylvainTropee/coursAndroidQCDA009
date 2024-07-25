package com.example.mod6demo3.repository

import com.example.mod6demo3.bo.Beverage
import com.example.mod6demo3.dao.BeverageDAO

class BeverageRepository(private val beverageDAO: BeverageDAO) {

    fun insertBeverage(beverage: Beverage){
        beverageDAO.insert(beverage)
    }

    fun findAllBeverage(): List<Beverage> {
        return beverageDAO.findAll()
    }

}