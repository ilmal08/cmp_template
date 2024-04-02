package com.ilmal08.kmptemplate.entity

data class NewsEntity(
    val copyright: String,
    val lastUpdated: String,
    val numResults: Int,
    val resultResponses: List<ResultEntity>,
    val section: String,
    val status: String
)