package com.reloader.corrutinasvmodel.domain

import com.reloader.corrutinasvmodel.data.network.IRepo
import com.reloader.corrutinasvmodel.vo.Resource

class UseCaseImpl(private val repo: IRepo) : IUseCase {

    override suspend fun getVersionCode(): Resource<Int> = repo.getVersionCodeRepo()


}