package com.ilmal08.kmptemplate.domain

import com.ilmal08.kmptemplate.entity.NewsEntity
import com.ilmal08.kmptemplate.data.model.BaseResponse
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    suspend fun getNews(): Flow<BaseResponse<NewsEntity?>>
}