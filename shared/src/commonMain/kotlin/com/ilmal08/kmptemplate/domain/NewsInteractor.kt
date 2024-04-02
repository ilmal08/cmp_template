package com.ilmal08.kmptemplate.domain

import com.ilmal08.kmptemplate.data.repository.NewsRepository
import com.ilmal08.kmptemplate.util.castDataFlow

class NewsInteractor(
    private val newsRepository: NewsRepository
) : NewsUseCase {

    override suspend fun getNews() = castDataFlow({ newsRepository.getNews() }) {
        it?.mapToEntity()
    }
}