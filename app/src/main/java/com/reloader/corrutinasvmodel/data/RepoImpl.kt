package com.reloader.corrutinasvmodel.data

import com.google.firebase.firestore.FirebaseFirestore
import com.reloader.corrutinasvmodel.data.network.IRepo
import com.reloader.corrutinasvmodel.vo.Resource
import kotlinx.coroutines.tasks.await

class RepoImpl : IRepo {
    override suspend fun getVersionCodeRepo(): Resource<Int> {
        //return Resource.Success(2)

        val resultData = FirebaseFirestore.getInstance()
            .collection("params").document("app").get().await()
        // firebase usa el task successfull, listener y con await resumimos ese problema va a Firebase lo busca termina y continua


        val versionCode = resultData.getLong("version")
        return Resource.Success(versionCode!!.toInt())
    }

}