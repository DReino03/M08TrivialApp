package com.reinosa.trivial.view

import android.print.PrintAttributes.Margins
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.reinosa.trivial.R

@Composable
fun menuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


    ) {
            Image(
                painter = painterResource(
                    id = R.drawable.triviallog
                ),
                contentDescription = "si",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.5f),
            )
            Button(onClick = {navController.navigate("playScreen")},
                modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                Text(text = "  Play  ")
            }
               Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Button(onClick = {navController.navigate("settingsScreen")}
                ,modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(text = "Settings")
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))


    }
}