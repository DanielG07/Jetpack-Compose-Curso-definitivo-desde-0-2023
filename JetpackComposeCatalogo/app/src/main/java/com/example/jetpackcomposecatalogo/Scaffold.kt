package com.example.jetpackcomposecatalogo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val scaffoldHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldHostState)
        },
        topBar = {
            MyTopAppBar {
                scope.launch { scaffoldHostState.showSnackbar("Has pulsado $it") }
            }
        },
    ) {
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primer toolbar") },
        colors =
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Red,
                titleContentColor = Color.White,
            ),
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Regresar") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "")
            }
            IconButton(onClick = { onClickIcon("Configuración") }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
            }
        },
    )
}
