package com.antoniowalls.fenstermvvm.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.antoniowalls.fenstermvvm.presentation.components.DefaultTopBar
import com.antoniowalls.fenstermvvm.presentation.screens.auth.register.components.RegisterContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        RegisterContent(paddingValues)
    }
}