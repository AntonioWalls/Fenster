package com.antoniowalls.fenstermvvm.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.antoniowalls.fenstermvvm.presentation.navigation.Graph
import com.antoniowalls.fenstermvvm.presentation.navigation.screen.AuthScreen
import com.antoniowalls.fenstermvvm.presentation.screens.auth.login.LoginScreen
import com.antoniowalls.fenstermvvm.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController)
        }
    }
}