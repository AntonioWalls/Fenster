package com.antoniowalls.fenstermvvm.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null
) {
        TopAppBar(
            title = {
                Text(
                    text = "Registro",
                    fontSize = 19.sp,
                    color = Color.Black
                )
            },
            navigationIcon = {
                if (upAvailable){
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }

            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                navigationIconContentColor = Color.Black,
                titleContentColor = Color.Black
            )
        )
    }
