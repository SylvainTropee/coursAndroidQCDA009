package com.example.mod6demo2

import android.provider.BaseColumns

data class Cake(
    val id: Long,
    val name: String,
    val taste: String
)

object CakeModel {

    const val TABLE_NAME = "cakes"
    const val COLUMN_NAME = "name"
    const val COLUMN_TASTE = "taste"

    const val DATABASE_NAME = "CakeStore.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_TABLE = """
        CREATE TABLE $TABLE_NAME
        (
            ${BaseColumns._ID} INTEGER PRIMARY KEY,
            $COLUMN_NAME TEXT,
            $COLUMN_TASTE TEXT
        )
    """

    const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}
