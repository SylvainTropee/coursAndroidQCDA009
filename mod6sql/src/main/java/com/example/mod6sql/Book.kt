package com.example.mod6sql

import android.provider.BaseColumns

data class Book(
    val id: Long,
    val name: String,
    val isbn: String,
    val author: String
)


object BookContract {

    const val DATABASE_NAME = "BookStore.db"
    const val DATABASE_VERSION = 1

    const val TABLE_NAME = "books"
    const val COLUMN_NAME = "name"
    const val COLUMN_ISBN = "isbn"
    const val COLUMN_AUTHOR = "author"



    const val SQL_CREATE = """
        CREATE TABLE $TABLE_NAME(
        ${BaseColumns._ID} INTEGER PRIMARY KEY,
        $COLUMN_NAME TEXT,
        $COLUMN_ISBN TEXT,
        $COLUMN_AUTHOR TEXT
        )        
    """

    const val SQL_DROP = "DROP TABLE IS EXISTS $TABLE_NAME"



}