package com.juani48.algorithmlibrary.application.usecase

import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.data.repository.CubeRepository
import javax.inject.Inject

class GetFilterCubeListUseCase @Inject constructor(private val repository: CubeRepository) {

    suspend fun execute(string: String): List<Cube>{
        return this.repository.getFilterCubes(string)
    }
    suspend fun test(string: String): List<Cube>{
        val list = listOf<Cube>(
            Cube(1,"Cube 1"),
            Cube(2,"Cube 2"),
            Cube(3,"Cube 3"),
            Cube(4,"Cube 4"),
            Cube(5,"Cube 5")
        )
        return list.filter { it.name.contains(string) }
    }
}