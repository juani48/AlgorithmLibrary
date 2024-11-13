package com.juani48.algorithmlibrary.application.entity

import com.juani48.algorithmlibrary.data.entity.CubeEntity

data class Cube(
    val id: Int = 0,
    val name: String,
)

fun CubeEntity.toDomain() = Cube(id = id, name = name)