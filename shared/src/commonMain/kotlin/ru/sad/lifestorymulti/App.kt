package ru.sad.lifestorymulti

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.ExperimentalCoroutinesApi
import moe.tlaster.precompose.navigation.BackHandler
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sad.lifestorymulti.data.api.LifestoryApi
import ru.sad.lifestorymulti.data.api.LifestoryApiImpl
import ru.sad.lifestorymulti.data.repositories.auth.AuthRepository
import ru.sad.lifestorymulti.data.repositories.auth.AuthRepositoryImpl
import ru.sad.lifestorymulti.di.getRepositoryModule
import ru.sad.lifestorymulti.theme.LifestoryTheme
import ru.sad.lifestorymulti.ui.navigation.NavigationGraph
import ru.sad.lifestorymulti.ui.screens.auth.AuthScreen
import ru.sad.lifestorymulti.ui.screens.auth.LoginViewModel

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
internal fun App() {
    val navigator = rememberNavigator()
    val isAppBarVisible = remember { mutableStateOf(true) }
    val searchProgressBar = remember { mutableStateOf(false) }

    startKoin {
        modules(listOf(getRepositoryModule()))
    }

    BackHandler(isAppBarVisible.value.not()) {
        isAppBarVisible.value = true
    }

    MaterialTheme {
        LifestoryTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MainScreenView(navigator)
//                AnimatedVisibility(
//                    visible = !isNetworkConnected,
//                    modifier = Modifier.align(Alignment.TopCenter),
//                    enter = scaleIn(),
//                    exit = scaleOut()
//                ) {
//                    SnackbarErrorNetworkConnection()
//                }
            }
        }
    }
}

@Composable
private fun MainScreenView(navigator: Navigator) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->
        NavigationGraph(
            navigator
        )
    }
}
