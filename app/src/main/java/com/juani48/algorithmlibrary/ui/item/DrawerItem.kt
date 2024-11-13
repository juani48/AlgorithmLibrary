package com.juani48.algorithmlibrary.ui.item

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class DrawerItem(
    val icon: ImageVector,
    val text: String
) {
    Home(Icons.Default.Home, "Menu Principal"),
    Search(Icons.Default.Search, "Buscar"),
    Add(Icons.Default.Add, "Añadir un cubo"),
    Upload(Icons.Default.Build, "Cargar algoritmo")
}