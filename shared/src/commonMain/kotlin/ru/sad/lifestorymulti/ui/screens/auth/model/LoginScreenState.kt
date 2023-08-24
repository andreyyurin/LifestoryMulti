package ru.sad.lifestorymulti.ui.screens.auth.model

sealed class LoginScreenState {

    data object Loading : LoginScreenState()

    data class Content(val test: String) : LoginScreenState()

    data object Error : LoginScreenState()
}
