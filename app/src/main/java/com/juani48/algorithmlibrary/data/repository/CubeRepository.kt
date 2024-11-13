package com.juani48.algorithmlibrary.data.repository

import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.entity.toDomain
import com.juani48.algorithmlibrary.data.dao.CubeDao
import com.juani48.algorithmlibrary.data.entity.CubeEntity
import com.juani48.algorithmlibrary.data.entity.toDataBase
import javax.inject.Inject

class CubeRepository @Inject constructor(private val cubeDao: CubeDao) {

    suspend fun getAllCubes(): List<Cube>{
        return this.cubeDao.getCubeList().map { it.toDomain() }
    }

    suspend fun getFilterCubes(string: String): List<Cube>{
        return this.cubeDao.getFilterCubes(string).map { it.toDomain() }
    }

    suspend fun addCube(cube: Cube){
        this.cubeDao.addCube(cube.toDataBase())
    }

    suspend fun getCube(id: Int): CubeEntity{
        return this.cubeDao.getCube(id)
    }
}