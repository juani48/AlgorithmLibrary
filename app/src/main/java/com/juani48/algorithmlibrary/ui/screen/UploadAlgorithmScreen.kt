package com.juani48.algorithmlibrary.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.ui.composable.DrawerContent
import com.juani48.algorithmlibrary.ui.composable.FAB
import com.juani48.algorithmlibrary.ui.composable.TopAppBar
import com.juani48.algorithmlibrary.ui.item.DrawerItem

@Preview
@Composable
fun TestUploadScreen(){
    UploadScreen({},{},{},{})
}

@Composable
fun UploadScreen(
    navigateToMainMenu: () -> Unit,
    navigateToAddCube: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToUpload: () -> Unit
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
                UploadContent(modifier = Modifier.padding(padding))
            },
            floatingActionButton = { FAB() { navigateToAddCube() } }
        )
    }
}

@Composable
fun UploadContent(modifier: Modifier) {
    Box(
        modifier = modifier
            .background(color = colorResource(R.color._light_blue))
            .fillMaxSize()
    ) {
        Spacer(Modifier.fillMaxSize(1f))
        Text(text = "Upload")
        Spacer(Modifier.fillMaxSize(1f))
    }
}