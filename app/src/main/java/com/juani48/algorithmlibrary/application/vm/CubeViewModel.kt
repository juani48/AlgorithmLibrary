package com.juani48.algorithmlibrary.application.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.usecase.AddCubeUseCase
import com.juani48.algorithmlibrary.application.usecase.GetCubeByIdUseCase
import com.juani48.algorithmlibrary.application.usecase.GetCubeListUseCase
import com.juani48.algorithmlibrary.application.usecase.GetFilterCubeListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CubeViewModel @Inject constructor(
    private val GetCubeList: GetCubeListUseCase,
    private val GetFilterList: GetFilterCubeListUseCase,
    private val AddCube: AddCubeUseCase,
    private val GetCubeById: GetCubeByIdUseCase,
) {

    private val _cubeList = MutableLiveData<List<Cube>>()
    val cubeList: LiveData<List<Cube>> = this._cubeList

    private val _cube = MutableLiveData<Cube>()
    val cube: LiveData<Cube> = this._cube

    fun initList(){
        CoroutineScope(Dispatchers.IO).launch {
            _cubeList.postValue(GetCubeList.execute())
        }
    }

    fun updateList(string: String){
        CoroutineScope(Dispatchers.IO).launch {
            _cubeList.postValue(GetFilterList.execute(string))
        }
    }

    fun addCube(cube: Cube){
        CoroutineScope(Dispatchers.IO).launch {
            AddCube.execute(cube)
        }
    }

    fun getCube(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            _cube.postValue(GetCubeById.execute(id))
        }
    }
}