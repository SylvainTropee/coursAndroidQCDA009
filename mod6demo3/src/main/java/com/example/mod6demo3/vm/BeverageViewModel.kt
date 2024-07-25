package com.example.mod6demo3.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod6demo3.bo.Beverage
import com.example.mod6demo3.db.BeverageDatabase
import com.example.mod6demo3.repository.BeverageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BeverageViewModel(private val beverageRepository: BeverageRepository) : ViewModel() {

    private val _beverages = MutableStateFlow<List<Beverage>>(emptyList())
    val beverages: StateFlow<List<Beverage>>
        get() = _beverages

    init {

        insertBeverage(
            Beverage(
                name = "Mojito",
                isAlcoholic = true,
                color = "transparent",
                price = 8f
            )
        )
        insertBeverage(
            Beverage(
                name = "Limonade",
                isAlcoholic = false,
                color = "transparent",
                price = 2f
            )
        )
        loadBeverage()
    }

    fun insertBeverage(beverage: Beverage) {
        viewModelScope.launch(Dispatchers.IO) {
//            val a = async { beverageRepository.insertBeverage(beverage) }
//            val b = async { beverageRepository.insertBeverage(beverage) }
//            awaitAll(a, b)
//            loadBeverage()

            //observer l'id pour déclencher l'appel à une autre méthode
            val id = beverageRepository.insertBeverage(beverage)
        }
    }

    fun loadBeverage() {
        viewModelScope.launch(Dispatchers.IO) {
            _beverages.value = beverageRepository.findAllBeverage()
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

                return BeverageViewModel(
                    BeverageRepository(
                        BeverageDatabase.getInstance(application.applicationContext)
                            .getBeverageDAO()
                    )
                ) as T
            }
        }
    }


}