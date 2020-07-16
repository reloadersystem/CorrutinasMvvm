package com.reloader.corrutinasvmodel.domain

import com.reloader.corrutinasvmodel.vo.Resource

interface IUseCase {

    suspend fun getVersionCode(): Resource<Int>
}