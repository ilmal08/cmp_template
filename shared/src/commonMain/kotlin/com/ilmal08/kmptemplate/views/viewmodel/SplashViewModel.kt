package com.ilmal08.kmptemplate.views.viewmodel

import cafe.adriel.voyager.core.model.StateScreenModel
import com.ilmal08.kmptemplate.repository.HomeRepository
import com.ilmal08.kmptemplate.repository.SplashRepository
import com.ilmal08.kmptemplate.views.state.BaseState

class SplashViewModel(
    private val repository: SplashRepository
) : StateScreenModel<BaseState>(BaseState.Init)