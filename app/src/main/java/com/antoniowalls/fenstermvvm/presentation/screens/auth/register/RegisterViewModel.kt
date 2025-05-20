package com.antoniowalls.fenstermvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel@Inject constructor(): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set
    var isValidForm by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set


    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onLastNameInput(input: String){
        state = state.copy(lastName = input)
    }

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String){
        state = state.copy(confirmPassword = input)
    }


    fun validateForm() = viewModelScope.launch {
        if(state.name == ""){
            errorMessage = "Porfavor ingrese un nombre"
        }
        else if(state.lastName == ""){
            errorMessage = "Porfavor ingrese un apellido"
        }
        else if(state.phone == ""){
            errorMessage = "Porfavor ingrese un telefono"
        }
        else if(state.email == ""){
            errorMessage = "Porfavor ingrese un email"
        }
        else if(state.password == ""){
            errorMessage = "Porfavor ingrese una contraseña"
        }
        else if(state.confirmPassword == ""){
            errorMessage = "Porfavor ingrese una confirmacion de contraseña"
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
        }
        else if(state.password.length < 6){
            errorMessage = "La contraseña debe de tener al menos 6 caracteres"
        }
        else if(state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
        }
        delay(3000)
        errorMessage = ""
    }
}
