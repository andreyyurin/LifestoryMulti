package ru.sad.lifestorymulti.ui.screens.auth

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import ru.sad.lifestorymulti.base.composables.LoadingScreen
import ru.sad.lifestorymulti.theme.dp20
import ru.sad.lifestorymulti.ui.screens.auth.model.LoginScreenEvent
import ru.sad.lifestorymulti.ui.screens.auth.model.LoginScreenState

@Composable
internal fun AuthScreen(
    navigator: Navigator,
    viewModel: LoginViewModel,
    modifier: Modifier = Modifier
) {
    val state = viewModel.state.collectAsState(initial = LoginScreenState.Content("mocha?"))

    when (val stateValue = state.value) {
        LoginScreenState.Loading -> {
            LoadingScreen(modifier = modifier)
        }

        is LoginScreenState.Content -> {
            LoginScreen(
                navigator,
                onLoginClick = {
                    viewModel.onEvent(LoginScreenEvent.Start)
                },
                stateValue.test
            )
        }

        LoginScreenState.Error -> {

        }
    }
}
@Composable
private fun LoginScreen(navigator: Navigator, onLoginClick: () -> Unit, str: String = "HER") {
    Text(
        text = str,
        fontSize = 25.sp,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(
                horizontal = dp20
            )
    )
}