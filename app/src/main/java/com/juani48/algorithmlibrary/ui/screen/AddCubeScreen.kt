package com.juani48.algorithmlibrary.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.vm.CubeViewModel
import com.juani48.algorithmlibrary.ui.composable.DrawerContent
import com.juani48.algorithmlibrary.ui.composable.Title
import com.juani48.algorithmlibrary.ui.composable.TopAppBar
import com.juani48.algorithmlibrary.ui.item.DrawerItem

@Composable
fun AddCubeScreen(
    cubeViewModel: CubeViewModel,
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
                AddCubeContent(
                    modifier = Modifier.padding(padding),
                    { cubeViewModel.addCube(it) },
                    { navigateToMainMenu() }
                )
            },
        )
    }
}

@Composable
fun AddCubeContent(
    modifier: Modifier,
    onClickAddButton: (Cube) -> Unit,
    navigateToMainMenu: () -> Unit
) {
    var text by remember { mutableStateOf("") }
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
            Title(stringResource(R.string.add_cube_title))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                label = {
                    Text(
                        color = colorResource(R.color._text),
                        text = "Ingrese el nombre del nuevo cubo",
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color._background),
                    unfocusedContainerColor = colorResource(R.color._background),
                    focusedIndicatorColor = colorResource(R.color._fronground),
                    cursorColor = colorResource(R.color._fronground),
                    focusedTextColor = colorResource(R.color._text),
                    focusedLabelColor = colorResource(R.color._fronground)
                ),
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    onClickAddButton(Cube(name = text))
                    navigateToMainMenu()
                },
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color._unselected)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 10.dp),
            ) {
                Text(
                    text = "Aceptar",
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


