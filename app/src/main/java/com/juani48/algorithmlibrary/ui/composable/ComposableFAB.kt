package com.juani48.algorithmlibrary.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.juani48.algorithmlibrary.R

@Composable
fun FAB(navigateToAddCube: () -> Unit) {
    FloatingActionButton(
        onClick = { navigateToAddCube() },
        containerColor = colorResource(R.color._unselected),
        contentColor = colorResource(R.color._text)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}