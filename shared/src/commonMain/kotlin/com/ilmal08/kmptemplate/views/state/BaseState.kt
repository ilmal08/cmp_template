package com.ilmal08.kmptemplate.views.state

sealed class BaseState {
    data object Init : BaseState()
    data object Loading : BaseState()
    data object Error : BaseState()
    data object Default : BaseState()
}