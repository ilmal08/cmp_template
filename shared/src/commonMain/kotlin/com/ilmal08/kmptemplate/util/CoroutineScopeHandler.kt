package com.ilmal08.kmptemplate.util

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.ScreenModelStore
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.plus

abstract class CoroutineStateHandler : ScreenModel {

    protected open fun onCleared() {}

    override fun onDispose() {
        super.onDispose()
        onCleared()
    }

}

val CoroutineStateHandler.coroutineState: CoroutineScope
    get() = ScreenModelStore.getOrPutDependency(
        screenModel = this,
        name = "ScreenModelCoroutineScope",
        factory = { key -> CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate) + CoroutineName(key) },
        onDispose = { scope -> scope.cancel() }
    )