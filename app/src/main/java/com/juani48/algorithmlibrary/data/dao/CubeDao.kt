package com.juani48.algorithmlibrary.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juani48.algorithmlibrary.data.entity.CubeEntity

@Dao
interface CubeDao {

    @Query("SELECT * FROM cube_table")
    suspend fun getCubeList(): List<CubeEntity>

    @Query("SELECT * FROM cube_table WHERE id = :id")
    suspend fun getCube(id: Int): CubeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCube(cubeEntity: CubeEntity)

    @Delete()
    suspend fun deleteCube(cubeEntity: CubeEntity)

    @Query("SELECT * FROM cube_table WHERE name LIKE '%' || :string || '%' ")
    suspend fun getFilterCubes(string: String): List<CubeEntity>

}