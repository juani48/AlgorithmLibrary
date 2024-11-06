package com.juani48.algorithmlibrary.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juani48.algorithmlibrary.application.entity.Cube

@Entity(tableName = "cube_table")
data class CubeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String
)

fun Cube.toDataBase() = CubeEntity(id = id, name = name)