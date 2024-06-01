package com.ilmal08.kmptemplate.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Composable
fun rememberPermissionState(
    permission: Permission,
    onPermissionResult: (Boolean) -> Unit = {}
): PermissionState {
    return rememberMutablePermissionState(permission, onPermissionResult)
}

@Stable
interface PermissionState {

    val permission: Permission

    val status: PermissionStatus

    fun launchPermissionRequest()

    fun openSettings()
}