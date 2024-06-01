package com.ilmal08.kmptemplate.permission

import android.Manifest
import android.os.Build

internal fun Permission.toPlatformPermission(): List<String> {
    return when (this) {
        Permission.CAMERA -> listOf(Manifest.permission.CAMERA)
        Permission.GALLERY -> galleryCompat()
        Permission.STORAGE -> allStoragePermissions()
        Permission.WRITE_STORAGE -> listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        Permission.LOCATION -> fineLocationCompat()
        Permission.COARSE_LOCATION -> listOf(Manifest.permission.ACCESS_COARSE_LOCATION)
        Permission.AUDIO -> listOf(Manifest.permission.RECORD_AUDIO)
    }
}

private fun allStoragePermissions() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    listOf(
        Manifest.permission.READ_MEDIA_AUDIO,
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.READ_MEDIA_VIDEO
    )
} else listOf(Manifest.permission.READ_EXTERNAL_STORAGE)

private fun galleryCompat() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    listOf(Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO)
} else listOf(Manifest.permission.READ_EXTERNAL_STORAGE)


private fun fineLocationCompat() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    listOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )
} else listOf(Manifest.permission.ACCESS_FINE_LOCATION)
