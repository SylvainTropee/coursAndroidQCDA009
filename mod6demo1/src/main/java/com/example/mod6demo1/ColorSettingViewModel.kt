package com.example.mod6demo1

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ColorSettingViewModel(private val userPreferencesRepository: UserPreferencesRepository) :
    ViewModel() {

    private val _userColor = MutableStateFlow<Color>(Color.White)
    val userColor: StateFlow<Color>
        get() = _userColor

    init {
        getBgColor()
    }

    fun setBgColor(color: Color) {
        viewModelScope.launch(Dispatchers.IO) {
            userPreferencesRepository.saveColor(color)
        }
    }

    fun getBgColor() {
        viewModelScope.launch(Dispatchers.IO) {
            userPreferencesRepository.getColor().collect { color ->
                _userColor.value = color
            }
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

                return ColorSettingViewModel(
                    UserPreferencesRepository(application.applicationContext)
                ) as T
            }
        }
    }


}