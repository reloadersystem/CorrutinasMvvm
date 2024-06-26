package com.reloader.corrutinasvmodel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.reloader.corrutinasvmodel.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {


    //cuando esta activa lo escucha, sino deja de escuchar livedata coroutines-play-services, no nos preocupamos
    //por el OnClear  o liberar memoria

    // emit reemplaza mutabletLiveData.value()
    val fetchVersionCode = liveData(Dispatchers.IO) {
        emit(Resource.Loading())


        try {

            val version = 2
            emit(version)
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }



}