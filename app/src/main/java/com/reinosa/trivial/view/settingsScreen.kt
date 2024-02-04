package com.reinosa.trivial.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.reinosa.trivial.viewModel.trivialViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingsScreen(navController: NavController,trivialViewModel: trivialViewModel){
    var selectedText : String by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) } // Set expanded to true to show dropdown initially
    var isOn = trivialViewModel.darkMode
    var selectedOption by rememberSaveable { mutableStateOf(trivialViewModel.totalRounds) }
    var selectedDiff by remember { mutableStateOf(trivialViewModel.difficulty)}

    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,)
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val difficulty = listOf("Easy", "Normal", "Difficult")
            Text(text = "Difficulty: ")
            OutlinedTextField(
                label = { Text(text = "Difficulty") },
                value = selectedDiff,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true}
            )
            DropdownMenu(

                expanded = expanded,
                onDismissRequest = { expanded = false},
                modifier = Modifier.fillMaxWidth(0.5f)) {
                difficulty.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(text = label) },
                        onClick = {
                            selectedDiff = label
                            expanded = false
                            trivialViewModel.changeDifficulty(selectedDiff)
                            trivialViewModel.changeQuestion()
                        }
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Rounds: ", modifier = Modifier.padding(end = 200.dp))
            Column() {
                val dif = listOf("5", "10", "15")
                dif.forEach { label ->
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOption.toString() == label,
                            onClick = {
                                selectedOption = label.toInt()
                                trivialViewModel.changeRounds(selectedOption)
                            })
                        Text(text = label)
                    }
                }
            }
        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Round Time:  ")
            slider(trivialViewModel)
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,) {
            Text(text = "Dark mode:  ")
            Switch( checked = isOn,
                onCheckedChange = { isOn = it
                    trivialViewModel.darkModeSwap()},)

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
@Composable
fun slider(trivialViewModel: trivialViewModel){
    var sliderValue by remember { mutableStateOf(5) }
    var finishValue by remember { mutableStateOf("") }
    Column() {
        Slider(
            value = sliderValue.toFloat(),
            onValueChange = { sliderValue = it.toInt() },
            onValueChangeFinished = { finishValue = sliderValue.toString() },
            valueRange = 5f..30f,
            steps = 10,
            colors = SliderDefaults.colors(
                activeTickColor = Color.Transparent,
                inactiveTickColor = Color.Transparent
            ),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        Text(
            text = sliderValue.toString(),
            //trivialViewModel.time = sliderValue.toInt())
        )

    }
}