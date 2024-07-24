package com.example.mod6demo2

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class CakeDAO(val dbW: SQLiteDatabase, val dbR: SQLiteDatabase) {

    fun insertCake(cake: Cake): Long {

        val values = ContentValues().apply {
            put(CakeModel.COLUMN_NAME, cake.name)
            put(CakeModel.COLUMN_TASTE, cake.taste)
        }

        val id = dbW.insert(CakeModel.TABLE_NAME, null, values)
        return id
    }

    fun findAllCakes(): List<Cake> {

        val cakes = mutableListOf<Cake>()

        //tableau des colonnes à récupérer
        val projection = arrayOf(
            BaseColumns._ID,
            CakeModel.COLUMN_NAME,
            CakeModel.COLUMN_TASTE
        )

        val cursor = dbR.query(
            CakeModel.TABLE_NAME,
            projection,
//            "${CakeModel.COLUMN_TASTE} = ?",
//            arrayOf("amer"),
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val cake = Cake(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    name = getString(getColumnIndexOrThrow(CakeModel.COLUMN_NAME)),
                    taste = getString(getColumnIndexOrThrow(CakeModel.COLUMN_TASTE))
                )

                cakes.add(cake)
            }
        }
        cursor.close()
        return cakes
    }

}