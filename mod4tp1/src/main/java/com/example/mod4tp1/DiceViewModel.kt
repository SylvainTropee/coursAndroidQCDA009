package com.example.mod4tp1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DiceViewModel : ViewModel()
{

    private var _totalRollNumber  = MutableStateFlow<Int>(0)
    var totalRollNumber : StateFlow<Int> = _totalRollNumber

    var diceNumberId : Int = R.drawable.d6

    var leftRollNumber : Int = 0
    var rightRollNumber : Int = 0
    var leftScore : Int = 0
    var rightScore : Int = 0

    fun rollDice(): Int {
        val currentRoll = (1..6).random()
        _totalRollNumber.value = _totalRollNumber.value.inc()

        when(currentRoll){
            1 -> diceNumberId = R.drawable.d1
            2 -> diceNumberId = R.drawable.d2
            3 -> diceNumberId = R.drawable.d3
            4 -> diceNumberId = R.drawable.d4
            5 -> diceNumberId = R.drawable.d5
            6 -> diceNumberId = R.drawable.d6
        }
        return currentRoll
    }

    fun rollLeft(){
        leftScore += rollDice()
        leftRollNumber++
    }

    fun rollRight(){
        rightScore += rollDice()
        rightRollNumber++
    }




}