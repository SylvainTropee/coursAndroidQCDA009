package com.example.mod6sql

class BookRepository(private val bookDAO: BookDAO) {

    fun insert(book: Book){
       bookDAO.insertBook(book)
    }

    fun getAllBooks(): List<Book> {
        return bookDAO.getAllBooks()
    }

}