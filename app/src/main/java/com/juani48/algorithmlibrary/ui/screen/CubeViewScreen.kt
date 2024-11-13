package com.juani48.algorithmlibrary.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.vm.CubeViewModel
import com.juani48.algorithmlibrary.ui.composable.*
import com.juani48.algorithmlibrary.ui.composable.TopAppBar
import com.juani48.algorithmlibrary.ui.item.DrawerItem

@Composable
fun CubeViewScreen(
    cubeViewModel: CubeViewModel,
    navigateToMainMenu: () -> Unit,
    navigateToAddCube: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToUploadAlgorithm: () -> Unit,
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
                    DrawerItem.Upload -> navigateToUploadAlgorithm()
                }
            }
        }
    ) {
        Scaffold(
            topBar = { TopAppBar(drawerState) },
            content = { padding: PaddingValues ->
                CubeViewContent(
                    modifier = Modifier.padding(padding),
                    cubeViewModel,
                )
            },
            floatingActionButton = { CubeViewFAB() { navigateToUploadAlgorithm() } }
        )
    }
}

@Composable
fun CubeViewContent(
    modifier: Modifier,
    cubeViewModel: CubeViewModel,
) {
    val cube: Cube by cubeViewModel.cube.observeAsState(initial = Cube(0, ""))
    Box(
        modifier = modifier
            .background(color = colorResource(R.color._background))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(string = cube.name)
        }
    }
}

@Composable
fun CubeViewFAB(

    navigateToUploadAlgorithm: () -> Unit
) {

}