package ru.sad.lifestorymulti.base.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import ru.sad.lifestorymulti.theme.RedFF512F
import ru.sad.lifestorymulti.theme.WhiteFDFDFFGrayEEF2FF
import ru.sad.lifestorymulti.theme.dp4
import ru.sad.lifestorymulti.theme.dp40

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .background(
            brush = WhiteFDFDFFGrayEEF2FF
        )
        .fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    CircularProgressIndicator(
        modifier = Modifier
            .size(dp40),
        color = RedFF512F,
        strokeWidth = dp4
    )
}