package com.juani48.algorithmlibrary.application.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.usecase.GetCubeListUseCase
import javax.inject.Inject

class CubeViewModel @Inject constructor(
    private val GetCubeList: GetCubeListUseCase
) {

    private val _cubeList = MutableLiveData<List<Cube>>()
    val cubeList: LiveData<List<Cube>> = this._cubeList

    fun init(){
        this._cubeList.value = this.GetCubeList.test()
    }

    fun setList(){
        this._cubeList.postValue(this.GetCubeList.test())
    }

}