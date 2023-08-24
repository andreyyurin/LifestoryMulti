package ru.sad.lifestorymulti.ui.screens.auth.model

sealed class LoginScreenAction {

    class NavigateTo(
        val route: String
    ) : LoginScreenAction()
}
