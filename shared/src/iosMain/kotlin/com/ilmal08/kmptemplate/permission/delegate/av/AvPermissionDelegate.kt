package com.ilmal08.kmptemplate.permission.delegate.av

import com.ilmal08.kmptemplate.permission.PermissionDelegate
import com.ilmal08.kmptemplate.permission.PermissionStatus
import platform.AVFoundation.AVAuthorizationStatus
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusDenied
import platform.AVFoundation.AVAuthorizationStatusNotDetermined
import platform.AVFoundation.AVAuthorizationStatusRestricted
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaType
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType

internal class AVPermissionDelegate(
    private val type: AVMediaType,
) : PermissionDelegate {

    override fun requestPermission(onPermissionResult: (PermissionStatus) -> Unit) {
        AVCaptureDevice.requestAccessForMediaType(type) {
            onPermissionResult(
                if (it) PermissionStatus.Granted else PermissionStatus.Denied(false)
            )
        }
    }

    override suspend fun getPermissionStatus(): PermissionStatus {
        return currentAuthorizationStatus().toCommonStatus()
    }

    private fun currentAuthorizationStatus(): AVAuthorizationStatus {
        return AVCaptureDevice.authorizationStatusForMediaType(type)
    }
}

private fun AVAuthorizationStatus.toCommonStatus(): PermissionStatus {
    return when (this) {
        AVAuthorizationStatusAuthorized -> PermissionStatus.Granted
        AVAuthorizationStatusNotDetermined -> PermissionStatus.NotDetermined
        AVAuthorizationStatusDenied -> PermissionStatus.Denied(true)
        AVAuthorizationStatusRestricted -> PermissionStatus.Granted
        else -> error("unknown authorization status $this")
    }
}