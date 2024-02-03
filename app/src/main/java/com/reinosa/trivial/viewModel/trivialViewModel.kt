package com.reinosa.trivial.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.reinosa.trivial.model.Pregunta
import com.reinosa.trivial.model.listaDePreguntasDificiles
import com.reinosa.trivial.model.listaDePreguntasFaciles
import com.reinosa.trivial.model.listaDePreguntasNormales

class trivialViewModel: ViewModel() {
    //PlayViewModel
    //Rondas
    //diff
    var difficulty : String by mutableStateOf("Easy")
        private set



    var round: Int by mutableStateOf(1)
        private set


    fun changeRound(newRound: Int) {
        round = newRound
    }

    //Preguntas
    var currentQuestion by mutableStateOf(chooseList()[round - 1])
        private set

    fun chooseList() : List<Pregunta> {
        return when (difficulty) {
            "Easy" -> listaDePreguntasFaciles
            "Normal" -> listaDePreguntasNormales
            "Difficult" -> listaDePreguntasDificiles
            else -> listOf()
        }
    }
    fun changeQuestion() {
        val quesList = chooseList()

        currentQuestion = quesList[round - 1]
    }

    //Puntos
    var points by mutableStateOf(0)
        private set

    fun addPoint(add: Int) {
        points += add
    }

    fun resetPoints() {
        points = 0
    }

    fun setPuntuation(selectedButton: String, correctButton: String) {
        if (selectedButton[0] == correctButton.first()) {
            addPoint(1)
        }else{
            addPoint(-1)
        }
    }
    //SettingsViewModel

    // Rondas
    var actualRound : Int by mutableStateOf(0)

    var totalRounds : Int by mutableStateOf(5)
        private set

    fun changeRounds(newRounds : Int) {
        totalRounds = newRounds
    }
    //Difficulty



    fun changeDifficulty(newDifficulty : String) {
        difficulty = newDifficulty
    }


    //DarkMode
    var darkMode : Boolean by mutableStateOf(false)
        private set

    fun darkModeSwap() {
        darkMode = !darkMode
    }


}