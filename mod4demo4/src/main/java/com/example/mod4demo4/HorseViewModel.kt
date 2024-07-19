package com.example.mod4demo4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HorseViewModel(horseRepository: HorseRepository) : ViewModel() {

    private val _horses = MutableStateFlow<List<String>>(emptyList())
    val horses: StateFlow<List<String>> = _horses

    init {
        _horses.value = horseRepository.getHorses()
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

                return HorseViewModel(
                    HorseRepository()
                ) as T
            }
        }
    }

}