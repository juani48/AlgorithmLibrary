package com.juani48.algorithmlibrary.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainMenu

@Serializable
object AddCube

@Serializable
object Search

@Serializable
object UploadAlgorithm

@Serializable
data class CubeView(val id: Int)
