package com.reloader.corrutinasvmodel.data.network

import com.reloader.corrutinasvmodel.vo.Resource

interface IRepo {
    suspend fun getVersionCodeRepo(): Resource<Int>
}