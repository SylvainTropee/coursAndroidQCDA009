package com.example.mod6sql

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>>
        get() = _books

    init {
        insertBook(Book(0L, "ghfgh", "123456", "Michel"))
        insertBook(Book(0L, "Lfghfghfa", "123456", "Jean-Paul"))
        loadBooks()
    }

    fun insertBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            bookRepository.insert(book)
        }
    }

    fun loadBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            _books.value = bookRepository.getAllBooks()
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val bookDbHelper = BookDbHelper(application.applicationContext)
                return BookViewModel(
                    BookRepository(BookDAO(bookDbHelper.readableDatabase, bookDbHelper.writableDatabase))
                ) as T
            }
        }
    }
}



