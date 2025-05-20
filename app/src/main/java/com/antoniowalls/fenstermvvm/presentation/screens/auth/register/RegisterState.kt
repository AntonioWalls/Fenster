package com.antoniowalls.fenstermvvm.presentation.screens.auth.register

data class RegisterState(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val phone: String = "",
    val confirmPassword: String = ""
)
