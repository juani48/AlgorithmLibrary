package com.juani48.algorithmlibrary.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun SearchScreen(
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
                SearchContent(
                    modifier = Modifier.padding(padding),
                    cubeViewModel,
                    {navigateToCubeView(it)}
                )
            },
            floatingActionButton = { FAB() { navigateToAddCube() } }
        )
    }
}

@Composable
fun SearchContent(
    modifier: Modifier,
    cubeViewModel: CubeViewModel,
    navigateToCubeView: (Int) -> Unit
) {

    val list: List<Cube> by cubeViewModel.cubeList.observeAsState(initial = listOf())

    Box(
        modifier = modifier
            .background(color = colorResource(R.color._background))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Title(stringResource(R.string.search_title))
            SearchOTF() { cubeViewModel.updateList(it) }
            Spacer(modifier = Modifier.height(15.dp))
            SearchCubeList(list) { navigateToCubeView(it)}
        }
    }
}

@Composable
fun SearchOTF(onTextChange: (String) -> Unit) {
    var string by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = string,
        onValueChange = {
            string = it
            onTextChange(string)
        },
        singleLine = true,
        label = {
            Text(
                color = colorResource(R.color._text),
                text = "Ingrese el nombre del cubo",
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = colorResource(R.color._text),
                contentDescription = null,
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color._background),
            unfocusedContainerColor = colorResource(R.color._background),
            focusedIndicatorColor = colorResource(R.color._fronground),
            cursorColor = colorResource(R.color._fronground),
            focusedTextColor = colorResource(R.color._text),
            focusedLabelColor = colorResource(R.color._fronground)
        )
    )
}

@Composable
fun SearchCubeList(list: List<Cube>, navigateToCubeView: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        flingBehavior = ScrollableDefaults.flingBehavior(),
    ) {
        items(list) { cube ->
            CubeItem(cube) {navigateToCubeView(it)}
        }
    }
}