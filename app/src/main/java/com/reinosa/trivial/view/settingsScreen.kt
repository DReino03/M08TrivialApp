package com.reinosa.trivial.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.reinosa.trivial.viewModel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingsScreen(navController: NavController, SettingsViewModel: SettingsViewModel){
    var selectedText : String by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) } // Set expanded to true to show dropdown initially
    val difficulty = listOf("Easy", "Normal", "Difficult", "WTF")
    var sliderValue by remember { mutableStateOf(0f) }
    var finishValue by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,)
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Difficulty:")
            OutlinedTextField(
                label = { Text(text = "Difficulty") },
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true}
            )
            DropdownMenu(

                expanded = expanded,
                onDismissRequest = { expanded = false},
                modifier = Modifier.fillMaxWidth()) {
                difficulty.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(text = label) },
                        onClick = {
                            selectedText = label
                            expanded = false
                        }
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Rounds")
            Column() {
                RadioButton(selected = SettingsViewModel.rounds5 , onClick = { SettingsViewModel.rounds5 = !SettingsViewModel.rounds5})
                RadioButton(selected = SettingsViewModel.rounds10  , onClick = { SettingsViewModel.rounds10 = !SettingsViewModel.rounds10})
                RadioButton(selected = SettingsViewModel.rounds15  , onClick = { SettingsViewModel.rounds15 = !SettingsViewModel.rounds15 },  )
            }
        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Round Time:  ")
            Slider(value = sliderValue,
                onValueChange = { sliderValue = it},
                onValueChangeFinished = { finishValue = sliderValue.toString()},
                valueRange = 0f..30f,
                steps = 10,
                colors = SliderDefaults.colors(
                    activeTickColor = Color.Transparent,
                    inactiveTickColor = Color.Transparent
                ),
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,) {
            Text(text = "Dark mode")
            //implementa el dark mode
            Switch(checked = false, onCheckedChange = { /*TODO*/ })

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 70.dp)
        ) {

            Button(onClick = {navController.navigate("menuScreen")}) {
                Text(text = "Back to menu")
            }

        }
    }

}