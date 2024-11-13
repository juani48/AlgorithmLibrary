package com.juani48.algorithmlibrary.application.usecase

import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.data.repository.CubeRepository
import javax.inject.Inject

class AddCubeUseCase @Inject constructor(val repository: CubeRepository) {

    suspend fun execute(cube: Cube){
        if(cube.name != ""){
            this.repository.addCube(cube)
        }
    }
}