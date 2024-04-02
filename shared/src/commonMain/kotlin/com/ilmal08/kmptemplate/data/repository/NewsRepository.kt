package com.ilmal08.kmptemplate.data.repository

import com.ilmal08.kmptemplate.data.model.response.NewsResponse
import com.ilmal08.kmptemplate.data.model.BaseResponse

interface NewsRepository {
    suspend fun getNews(): BaseResponse<NewsResponse?>
}