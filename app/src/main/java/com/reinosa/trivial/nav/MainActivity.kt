package com.reinosa.trivial.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reinosa.trivial.ui.theme.TrivialTheme
import com.reinosa.trivial.view.finalScreen
import com.reinosa.trivial.view.launchScreen
import com.reinosa.trivial.view.menuScreen
import com.reinosa.trivial.view.playScreen
import com.reinosa.trivial.view.settingsScreen
import com.reinosa.trivial.viewModel.trivialViewModel

val trivialViewModel = trivialViewModel()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            TrivialTheme(darkTheme = trivialViewModel.darkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavegationGraph()
                }
            }
        }
    }
}
@Composable
fun NavegationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.launchScreen.route){

        composable(route = Routes.launchScreen.route){launchScreen(navController) }
        composable(route = Routes.menuScreen.route){menuScreen(navController)}
        composable(route = Routes.playScreen.route){playScreen(navController,trivialViewModel)}
        composable(route = Routes.settingsScreen.route){settingsScreen(navController,trivialViewModel)}
        composable(route = Routes.resultScreen.route){finalScreen(navController,trivialViewModel)}


    }
}


