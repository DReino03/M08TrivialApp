package com.reinosa.trivial.view

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.reinosa.trivial.viewModel.trivialViewModel


@Composable
fun finalScreen(navController: NavController,trivialViewModel: trivialViewModel){

Column(
    modifier = Modifier
        .background(color = Color.DarkGray)
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
) {
    Text(text = "¡Has conseguido ${trivialViewModel.points} puntos en Trivial!")
    Spacer(modifier = Modifier.padding(100.dp))
    Button(
        onClick = {
            trivialViewModel.resetPoints()
            trivialViewModel.actualRound = 0
            navController.navigate("menuScreen")

    }) {
        Text(text = "Play again")
    }
    Share(text = "¡Has conseguido ${trivialViewModel.points} puntos en Trivial!")
}

}
@Composable
fun Share(text: String) {
    val context = LocalContext.current
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share with...")
    Button(onClick = {
        startActivity(context, shareIntent, null)
    }) {
        Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
        Text("Share", modifier = Modifier.padding(start = 8.dp))
    }
}