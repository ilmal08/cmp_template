package com.ilmal08.kmptemplate.views.viewmodel

import com.ilmal08.kmptemplate.domain.repository.SplashRepository
import com.ilmal08.kmptemplate.util.CoroutineStateHandler

class SplashViewModel(
    private val repository: SplashRepository
) : CoroutineStateHandler()