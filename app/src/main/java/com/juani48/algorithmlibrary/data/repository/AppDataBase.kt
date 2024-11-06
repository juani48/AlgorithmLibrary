package com.juani48.algorithmlibrary.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juani48.algorithmlibrary.data.dao.CubeDao
import com.juani48.algorithmlibrary.data.entity.CubeEntity

@Database(entities = [CubeEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getCubeDao(): CubeDao
}