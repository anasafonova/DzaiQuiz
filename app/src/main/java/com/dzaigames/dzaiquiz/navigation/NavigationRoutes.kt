package com.dzaigames.dzaiquiz.navigation

sealed class NavigationRoutes(val route: String) {
    object MainMenuScreen : NavigationRoutes("MainMenuScreen")
//    object Screen2 : NavigationDestination("screen2")
}
