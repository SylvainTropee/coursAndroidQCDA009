package com.example.mod6demo3

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mod6demo3.bo.Beverage
import com.example.mod6demo3.db.BeverageDatabase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BeverageDbTest {

    lateinit var db: BeverageDatabase

    @Before
    fun createDb() {
        //créer la base de données de test
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BeverageDatabase::class.java
        ).build()

    }

    @Test
    fun testInsertBeverage() {

        val beverage = Beverage(
            name = "Chardonnay-Cola",
            price = 15f,
            color = "mazout",
            isAlcoholic = true
        )

        val id = db.getBeverageDAO().insert(beverage)
        val b = db.getBeverageDAO().findById(id)

        Assert.assertTrue("Pas de boisson trouvée", b.id == id)

    }

}