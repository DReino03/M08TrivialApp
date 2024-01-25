package com.reinosa.trivial.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class contadorViewModel: ViewModel() {
    private var isRunning = false
    private var countDownTime = 0L
    private var currentTimeLeft = 0L

    fun startCountdown(timeInMillis: Long) {
        if (!isRunning) {
            countDownTime = timeInMillis
            currentTimeLeft = countDownTime

            viewModelScope.launch {
                isRunning = true
                while (currentTimeLeft > 0) {
                    delay(1000)
                    currentTimeLeft -= 1000
                }
                isRunning = false
            }
        }
    }

    fun stopCountdown() {
        isRunning = false
        currentTimeLeft = 0
    }

    fun getCurrentTimeLeft(): Long {
        return currentTimeLeft
    }

    fun isCountdownRunning(): Boolean {
        return isRunning
    }
}