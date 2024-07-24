package com.example.mod6demo2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CakeDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    CakeModel.DATABASE_NAME,
    null,
    CakeModel.DATABASE_VERSION
) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CakeModel.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(CakeModel.SQL_DROP_TABLE)
        onCreate(p0)
    }


}