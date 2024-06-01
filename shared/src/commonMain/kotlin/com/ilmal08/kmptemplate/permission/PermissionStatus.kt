package com.ilmal08.kmptemplate.permission

sealed interface PermissionStatus {
    data object Granted : PermissionStatus

    data object NotDetermined : PermissionStatus

    data class Denied(
        val shouldShowRationale: Boolean
    ) : PermissionStatus
}

val PermissionStatus.isGranted: Boolean
    get() = this == PermissionStatus.Granted