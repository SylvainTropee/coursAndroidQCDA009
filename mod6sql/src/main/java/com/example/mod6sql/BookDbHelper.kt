package com.example.mod6sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    BookContract.DATABASE_NAME,
    null,
    BookContract.DATABASE_VERSION
) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(BookContract.SQL_CREATE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(BookContract.SQL_DROP)
        onCreate(p0)
    }
}