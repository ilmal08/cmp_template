package com.ilmal08.kmptemplate.permission

import com.ilmal08.kmptemplate.permission.delegate.av.AVPermissionDelegate
import com.ilmal08.kmptemplate.permission.delegate.galery.GalleryPermissionDelegate
import com.ilmal08.kmptemplate.permission.delegate.location.LocationManagerDelegate
import com.ilmal08.kmptemplate.permission.delegate.location.LocationPermissionDelegate
import com.ilmal08.kmptemplate.permission.delegate.storage.StoragePermissionDelegate
import platform.AVFoundation.AVMediaTypeAudio
import platform.AVFoundation.AVMediaTypeVideo

internal fun Permission.getDelegate(): PermissionDelegate {
    return when (this) {
        Permission.LOCATION,
        Permission.COARSE_LOCATION -> LocationPermissionDelegate(LocationManagerDelegate())
        Permission.STORAGE, Permission.WRITE_STORAGE -> StoragePermissionDelegate()
        Permission.GALLERY -> GalleryPermissionDelegate()
        Permission.AUDIO -> AVPermissionDelegate(AVMediaTypeAudio)
        Permission.CAMERA -> AVPermissionDelegate(AVMediaTypeVideo)
    }
}