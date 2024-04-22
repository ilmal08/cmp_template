package com.ilmal08.kmptemplate.views.state

sealed class BaseState {
    object Init : BaseState()
    object Loading : BaseState()
    object Error : BaseState()
    object Default : BaseState()
}