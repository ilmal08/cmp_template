package com.ilmal08.kmptemplate.permission.delegate.storage

import com.ilmal08.kmptemplate.permission.PermissionDelegate
import com.ilmal08.kmptemplate.permission.PermissionStatus

internal class StoragePermissionDelegate : PermissionDelegate {

    override fun requestPermission(onPermissionResult: (PermissionStatus) -> Unit) {
        onPermissionResult(PermissionStatus.Granted)
    }

    override suspend fun getPermissionStatus(): PermissionStatus = PermissionStatus.Granted
}
