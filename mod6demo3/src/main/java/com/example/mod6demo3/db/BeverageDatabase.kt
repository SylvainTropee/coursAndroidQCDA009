package com.example.mod6demo3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mod6demo3.bo.Beverage
import com.example.mod6demo3.dao.BeverageDAO

@Database(entities = [Beverage::class], version = 1)
abstract class BeverageDatabase : RoomDatabase() {

    //liste des daos à utiliser
    abstract fun getBeverageDAO() : BeverageDAO

    companion object {

        private var INSTANCE: BeverageDatabase? = null

        fun getInstance(context: Context): BeverageDatabase {

            var instance = INSTANCE

            if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    BeverageDatabase::class.java,
                    "Beverage.db"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
            }
            return instance
        }


    }


}