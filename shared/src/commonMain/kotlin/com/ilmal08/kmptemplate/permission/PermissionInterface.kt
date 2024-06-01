package com.ilmal08.kmptemplate.permission

import androidx.compose.runtime.Composable

@Composable
internal expect fun rememberMutablePermissionState(
    permission: Permission,
    onPermissionResult: (Boolean) -> Unit
): PermissionState