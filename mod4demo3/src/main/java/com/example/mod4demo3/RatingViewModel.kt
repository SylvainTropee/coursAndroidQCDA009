package com.example.mod4demo3

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RatingViewModel : ViewModel() {

    private val _rating = MutableStateFlow(5f)
    val rating : StateFlow<Float> = _rating

    private val _userAnswer = MutableStateFlow("")
    val userAnswer : StateFlow<String> = _userAnswer

    fun updateRating(currentRating : Float){
        _rating.value = currentRating
    }

    fun updateUserAnswer(answer : String){
        _userAnswer.value = answer
    }

    fun saveInDbb(){
        //insert(_userAnswer.value)
    }



}