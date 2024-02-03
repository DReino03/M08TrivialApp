package com.reinosa.trivial.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.reinosa.trivial.viewModel.trivialViewModel
import kotlinx.coroutines.delay

@Composable
fun playScreen(navController: NavController, trivialViewModel: trivialViewModel) {
    var timeLeft by rememberSaveable { mutableStateOf(15) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row {
            Text(text = "Points: ${trivialViewModel.points}")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(text = "Difficulty: ${trivialViewModel.difficulty}")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row() {
            Text(text = "Round: ${trivialViewModel.actualRound}/${trivialViewModel.totalRounds}")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Row {
            Text(text = "${trivialViewModel.currentQuestion.enunciado}")
        }
        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    trivialViewModel.setPuntuation(
                        trivialViewModel.currentQuestion.opcionA,
                        trivialViewModel.currentQuestion.respuestaCorrecta
                    )
                    trivialViewModel.changeRound(trivialViewModel.round + 1)
                    trivialViewModel.changeQuestion()
                    trivialViewModel.actualRound = trivialViewModel.actualRound + 1
                    timeLeft = 15

                }) {
                Text(text = "${trivialViewModel.currentQuestion.opcionA}")
            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    trivialViewModel.setPuntuation(
                        trivialViewModel.currentQuestion.opcionB,
                        trivialViewModel.currentQuestion.respuestaCorrecta
                    )
                    trivialViewModel.actualRound = trivialViewModel.actualRound + 1
                    trivialViewModel.changeRound(trivialViewModel.round + 1)
                    trivialViewModel.changeQuestion()
                    timeLeft = 15

                }) {
                Text(text = "${trivialViewModel.currentQuestion.opcionB}")
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    trivialViewModel.setPuntuation(
                        trivialViewModel.currentQuestion.opcionC,
                        trivialViewModel.currentQuestion.respuestaCorrecta
                    )
                    trivialViewModel.actualRound = trivialViewModel.actualRound + 1


                    trivialViewModel.changeRound(trivialViewModel.round + 1)
                    trivialViewModel.changeQuestion()
                    timeLeft = 15

                }) {
                Text(text = "${trivialViewModel.currentQuestion.opcionC}")

            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    trivialViewModel.setPuntuation(
                        trivialViewModel.currentQuestion.opcionD,
                        trivialViewModel.currentQuestion.respuestaCorrecta
                    )
                    trivialViewModel.actualRound = trivialViewModel.actualRound + 1

                    trivialViewModel.changeRound(trivialViewModel.round + 1)
                    trivialViewModel.changeQuestion()
                    timeLeft = 15

                }) {
                Text(text = "${trivialViewModel.currentQuestion.opcionD}")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            LaunchedEffect(timeLeft) {
                while (timeLeft > 0) {
                    delay(1000L)
                    timeLeft--
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Time left: $timeLeft")
                LinearProgressIndicator(progress = timeLeft.toFloat() / 15f)
            }

        }
    }
    stopApp(navController, trivialViewModel,timeLeft)

}


fun stopApp(navController: NavController, settings: trivialViewModel,timeLeft:Int){
    if (timeLeft == 0){
        settings.actualRound = settings.totalRounds
        navController.navigate("resultScreen")
    }
    else if (settings.actualRound == settings.totalRounds){
        navController.navigate("resultScreen")
    }
}
