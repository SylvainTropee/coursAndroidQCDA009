package com.example.mod6demo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CakeViewModel(private val cakeRepository: CakeRepository) : ViewModel() {

    private val _cakes = MutableStateFlow<List<Cake>>(emptyList())
    val cakes: StateFlow<List<Cake>>
        get() = _cakes

    init {
        insertCake(Cake(id = 0L, name = "Paris-Brest", taste = "praline"))
        insertCake(Cake(id = 0L, name = "Fondant au chocolat", taste = "chocolat"))
        findAllCakes()
    }

    fun insertCake(cake: Cake) {
        viewModelScope.launch(Dispatchers.IO) {
            cakeRepository.insert(cake)
        }
    }

    fun findAllCakes() {
        viewModelScope.launch(Dispatchers.IO) {
            _cakes.value = cakeRepository.findAll()
        }
    }

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                val cakeDbHelper = CakeDbHelper(application.applicationContext)

                return CakeViewModel(
                    CakeRepository(
                        CakeDAO(
                            cakeDbHelper.writableDatabase,
                            cakeDbHelper.readableDatabase
                        )
                    )
                ) as T
            }
        }
    }

}