package com.juani48.algorithmlibrary.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.juani48.algorithmlibrary.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(drawerState: DrawerState) {
    TopAppBar(
        title = { TopAppBarTitle() },
        navigationIcon = { TopAppBarNavigationIcon(drawerState) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color._ground),
            titleContentColor = colorResource(R.color._text),
            navigationIconContentColor = colorResource(R.color._text),
        )
    )
}

@Composable
fun TopAppBarTitle() {
    Text(text = stringResource(R.string.app_name))
}

@Composable
fun TopAppBarNavigationIcon(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    IconButton(
        onClick = { scope.launch { drawerState.open() } }
    ) { Icon(imageVector = Icons.Default.Menu, contentDescription = "") }
}
