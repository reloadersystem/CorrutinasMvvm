package com.reloader.corrutinasvmodel.data

import com.reloader.corrutinasvmodel.data.network.IRepo
import com.reloader.corrutinasvmodel.vo.Resource

class RepoImpl : IRepo {
    override suspend fun getVersionCodeRepo(): Resource<Int> {
        return Resource.Success(2)
    }

}