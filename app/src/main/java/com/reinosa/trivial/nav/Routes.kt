package com.reinosa.trivial.nav

sealed class Routes(val route: String) {
    object launchScreen:Routes("launchScreen")
    object menuScreen:Routes("menuScreen")
    object playScreen:Routes("playScreen")
    object settingsScreen:Routes("settingsScreen")
    object resultScreen:Routes("resultScreen/{attempts}"){
        fun createRoute(attempts:Int) = "ResultScreen/$attempts"
    }
}
