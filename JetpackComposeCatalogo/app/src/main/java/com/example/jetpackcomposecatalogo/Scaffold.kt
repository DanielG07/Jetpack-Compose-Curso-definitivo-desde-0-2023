package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val scaffoldHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { MyDrawer() },
    ) {
        Scaffold(
            snackbarHost = {
                SnackbarHost(scaffoldHostState)
            },
            topBar = {
                MyTopAppBar(
                    onClickIcon = { scope.launch { scaffoldHostState.showSnackbar("Has pulsado $it") } },
                    onClickMenuIcon = { scope.launch { drawerState.open() } },
                )
            },
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.Center,
        ) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    onClickIcon: (String) -> Unit,
    onClickMenuIcon: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "Mi primer toolbar") },
        colors =
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Red,
                titleContentColor = Color.White,
            ),
        navigationIcon = {
            IconButton(onClick = { onClickMenuIcon() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
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

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }

    NavigationBar(containerColor = Color.Red) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "home",
                )
            },
            label = { Text(text = "Home") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color.Gray,
                ),
        )

        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "favorite",
                )
            },
            label = { Text(text = "Favorite") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color.Gray,
                ),
        )

        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "person",
                )
            },
            label = { Text(text = "Person") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color.Gray,
                ),
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Red,
        contentColor = Color.White,
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawer() {
    ModalDrawerSheet {
        Text(
            text = "Primer opción",
            modifier = Modifier.padding(vertical = 8.dp),
        )
        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            onClick = { /*TODO*/ },
        )
    }
}
