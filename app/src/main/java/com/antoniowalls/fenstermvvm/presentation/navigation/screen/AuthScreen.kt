package com.antoniowalls.fenstermvvm.presentation.navigation.screen

sealed class AuthScreen(val route: String) {
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
}