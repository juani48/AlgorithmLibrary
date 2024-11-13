package com.juani48.algorithmlibrary.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.vm.CubeViewModel
import com.juani48.algorithmlibrary.ui.composable.CubeItem
import com.juani48.algorithmlibrary.ui.composable.DrawerContent
import com.juani48.algorithmlibrary.ui.composable.FAB
import com.juani48.algorithmlibrary.ui.composable.Title
import com.juani48.algorithmlibrary.ui.composable.TopAppBar
import com.juani48.algorithmlibrary.ui.item.DrawerItem

@Composable
fun MainMenuScreen(
    cubeViewModel: CubeViewModel,
    navigateToMainMenu: () -> Unit,
    navigateToAddCube: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToUpload: () -> Unit,
    navigateToCubeView: (Int) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
            {
                when (it) {
                    DrawerItem.Home -> navigateToMainMenu()
                    DrawerItem.Search -> navigateToSearch()
                    DrawerItem.Add -> navigateToAddCube()
                    DrawerItem.Upload -> navigateToUpload()
                }
            }
        }
    ) {
        Scaffold(
            topBar = { TopAppBar(drawerState) },
            content = { padding: PaddingValues ->
                MainMenuContent(
                    modifier = Modifier.padding(padding),
                    cubeViewModel,
                    { navigateToCubeView(it) }
                )
            },
            floatingActionButton = { FAB() { navigateToAddCube() } }
        )
    }
}

@Composable
fun MainMenuContent(
    modifier: Modifier,
    cubeViewModel: CubeViewModel,
    navigateToCubeView: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .background(colorResource(R.color._background))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(stringResource(R.string.main_menu_title))
            MainMenuCubeList(cubeViewModel) {navigateToCubeView(it)}
        }
    }
}

@Composable
fun MainMenuCubeList(cubeViewModel: CubeViewModel, onCubeClicked: (Int) -> Unit) {
    val list: List<Cube> by cubeViewModel.cubeList.observeAsState(initial = listOf())

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        flingBehavior = ScrollableDefaults.flingBehavior(),
    ) {
        items(list) { cube ->
            CubeItem(cube) {onCubeClicked(it)}
        }
    }
}

