package com.ilmal08.kmptemplate.domain.repository

import com.ilmal08.kmptemplate.data.source.remote.SplashService
import com.ilmal08.kmptemplate.domain.DispatcherHandler

class SplashDataRepository(
    private val homeService: SplashService,
    private val dispatcherHandler: DispatcherHandler = DispatcherHandler.IO,
)