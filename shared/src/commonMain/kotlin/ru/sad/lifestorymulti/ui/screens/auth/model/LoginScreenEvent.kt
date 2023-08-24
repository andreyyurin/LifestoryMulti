package ru.sad.lifestorymulti.ui.screens.auth.model

sealed class LoginScreenEvent {

    data object Start: LoginScreenEvent()

    data object ClickOnLogin : LoginScreenEvent()

    data object ClickOnForgotPassword : LoginScreenEvent()
}