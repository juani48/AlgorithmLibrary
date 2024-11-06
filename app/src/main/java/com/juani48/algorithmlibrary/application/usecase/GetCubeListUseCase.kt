package com.juani48.algorithmlibrary.application.usecase

import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.data.repository.CubeRepository
import javax.inject.Inject

class GetCubeListUseCase @Inject constructor( private val repository: CubeRepository) {

    suspend fun execute(): List<Cube> = this.repository.getAllCubes()

    fun test() = listOf<Cube>(
        Cube(1,"Cube 1"),
        Cube(2,"Cube 2"),
        Cube(3,"Cube 3"),
        Cube(4,"Cube 4"),
        Cube(5,"Cube 5")
    )

}