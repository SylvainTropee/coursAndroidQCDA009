package com.example.mod6sql

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class BookDAO(val dbW: SQLiteDatabase, val dbR: SQLiteDatabase) {

    fun insertBook(book: Book): Boolean {
        val values = ContentValues().apply {
            put(BookContract.COLUMN_NAME, book.name)
            put(BookContract.COLUMN_AUTHOR, book.author)
            put(BookContract.COLUMN_ISBN, book.isbn)
        }

        val newRowId = dbW.insert(BookContract.TABLE_NAME, null, values)
        return newRowId != -1L
    }

    fun getAllBooks(): List<Book> {
        val projection = arrayOf(
            BaseColumns._ID,
            BookContract.COLUMN_NAME,
            BookContract.COLUMN_AUTHOR,
            BookContract.COLUMN_ISBN
        )

        val cursor = dbR.query(
            BookContract.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            "${BookContract.COLUMN_NAME} DESC"
        )

        val books = mutableListOf<Book>()
        with(cursor) {
            while (moveToNext()) {
                val book = Book(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    name = getString(getColumnIndexOrThrow(BookContract.COLUMN_NAME)),
                    isbn = getString(getColumnIndexOrThrow(BookContract.COLUMN_ISBN)),
                    author = getString(getColumnIndexOrThrow(BookContract.COLUMN_AUTHOR)),
                )

                books.add(book)
            }
        }
        cursor.close()
        return books
    }
}