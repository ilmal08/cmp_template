package com.ilmal08.kmptemplate.permission

internal interface PermissionDelegate {
    fun requestPermission(onPermissionResult: (PermissionStatus) -> Unit)
    suspend fun getPermissionStatus(): PermissionStatus
}
