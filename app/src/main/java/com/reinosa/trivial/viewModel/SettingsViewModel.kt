package com.reinosa.trivial.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel() {
    var rounds5 by mutableStateOf(false)
    var rounds10 by mutableStateOf(false)
    var rounds15 by mutableStateOf(false)

}