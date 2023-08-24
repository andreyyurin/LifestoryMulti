package ru.sad.lifestorymulti.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModel
import org.koin.compose.getKoin
import org.koin.mp.KoinPlatformTools
import ru.sad.lifestorymulti.ui.screens.auth.AuthScreen
import ru.sad.lifestorymulti.ui.screens.auth.LoginViewModel

@Composable
fun NavigationGraph(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = NavigationScreen.Auth.route,
    ) {
        scene(route = NavigationScreen.Auth.route) {
            val viewModel = LoginViewModel()
            AuthScreen(navigator, viewModel)
        }
    }
}

@Composable
fun currentRoute(navigator: Navigator): String? {
    return navigator.currentEntry.collectAsState(null).value?.route?.route
}