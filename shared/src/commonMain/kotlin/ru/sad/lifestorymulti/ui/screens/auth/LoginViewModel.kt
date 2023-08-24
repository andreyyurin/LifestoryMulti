package ru.sad.lifestorymulti.ui.screens.auth

import io.ktor.util.logging.KtorSimpleLogger
import io.ktor.util.logging.Logger
import org.koin.mp.KoinPlatformTools
import ru.sad.lifestorymulti.base.BaseViewModel
import ru.sad.lifestorymulti.data.repositories.auth.AuthRepositoryImpl
import ru.sad.lifestorymulti.ui.screens.auth.model.LoginScreenAction
import ru.sad.lifestorymulti.ui.screens.auth.model.LoginScreenDialogState
import ru.sad.lifestorymulti.ui.screens.auth.model.LoginScreenEvent
import ru.sad.lifestorymulti.ui.screens.auth.model.LoginScreenState

class LoginViewModel :
    BaseViewModel<LoginScreenState, LoginScreenDialogState, LoginScreenEvent, LoginScreenAction>() {

    private val authRepository: AuthRepositoryImpl = lazyRepository()

    override fun onEvent(event: LoginScreenEvent) {
        when (event) {
            LoginScreenEvent.Start -> handleStartEvent()
            LoginScreenEvent.ClickOnLogin -> handleClickOnLogin()
            LoginScreenEvent.ClickOnForgotPassword -> handleClickResetPassword()
            else -> {}
        }
    }

    private fun handleStartEvent() {
        launchIO({
            setState(LoginScreenState.Content(it))
        }) {
            setState(LoginScreenState.Content(authRepository.auth("TESTIdsadsaRUI").username ?: "success"))
        }
    }

    private fun handleClickOnLogin() {
        setState(LoginScreenState.Loading)
    }

    private fun handleClickResetPassword() {

    }
}