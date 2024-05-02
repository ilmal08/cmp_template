package com.ilmal08.kmptemplate.domain.repository

import com.ilmal08.kmptemplate.data.source.remote.HomeService
import com.ilmal08.kmptemplate.domain.DispatcherHandler
import com.ilmal08.kmptemplate.domain.entity.NewsEntity
import com.ilmal08.kmptemplate.domain.entity.common.ErrorEntity.Companion.apiError
import com.ilmal08.kmptemplate.domain.entity.common.Result
import com.ilmal08.kmptemplate.domain.entity.common.Result.Companion.error
import com.ilmal08.kmptemplate.domain.entity.common.Result.Companion.success


class HomeDataRepository(
    private val homeService: HomeService,
    private val dispatcherHandler: DispatcherHandler = DispatcherHandler.IO,
) {
    suspend fun getNews(): Result<NewsEntity?> = dispatcherHandler.execute {

        val apiResponse = homeService.getNews()

        if (apiResponse != null) {
            success(apiResponse.mapToEntity())
        } else {
            error(apiError(errorMessage = "error api", responseCode = 504))
        }
    }
}