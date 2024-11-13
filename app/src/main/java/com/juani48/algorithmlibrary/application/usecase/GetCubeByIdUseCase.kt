package com.juani48.algorithmlibrary.application.usecase

import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.entity.toDomain
import com.juani48.algorithmlibrary.data.repository.CubeRepository
import javax.inject.Inject

class GetCubeByIdUseCase @Inject constructor(val repository: CubeRepository) {

    suspend fun execute(id: Int): Cube{
        return this.repository.getCube(id).toDomain()
    }
}