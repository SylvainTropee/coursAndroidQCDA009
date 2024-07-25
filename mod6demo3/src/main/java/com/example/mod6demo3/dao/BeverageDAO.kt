package com.example.mod6demo3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mod6demo3.bo.Beverage


@Dao
interface BeverageDAO {

    @Insert
    fun insert(beverage: Beverage) : Long

    @Update
    fun update(beverage: Beverage)

    @Query("DELETE FROM Beverage WHERE id = :id")
    fun delete (id : Long)
//    @Delete
//    fun delete2(beverage: Beverage)

    @Query("SELECT * FROM Beverage")
    fun findAll() : List<Beverage>

    @Query("SELECT * FROM Beverage WHERE id = :id")
    fun findById(id : Long) : Beverage

}