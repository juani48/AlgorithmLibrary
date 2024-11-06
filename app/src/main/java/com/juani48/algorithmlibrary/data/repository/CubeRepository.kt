package com.juani48.algorithmlibrary.data.repository

import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.entity.toDomain
import com.juani48.algorithmlibrary.data.dao.CubeDao
import javax.inject.Inject

class CubeRepository @Inject constructor(private val cubeDao: CubeDao) {

    suspend fun getAllCubes(): List<Cube>{
        return this.cubeDao.getCubeList().map { it.toDomain() }
    }

}