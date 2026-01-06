package com.example.myapplication.ui

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun PermissionRequester() {
    val permissions = listOf(
        android.Manifest.permission.CAMERA,
        if (android.os.Build.VERSION.SDK_INT >= 33)
            android.Manifest.permission.READ_MEDIA_IMAGES
        else
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val cameraGranted = result[android.Manifest.permission.CAMERA] == true
        val galleryGranted = result.values.any { it }

        // тут можешь сохранить состояние, лог или показать UI
    }

    LaunchedEffect(Unit) {
        launcher.launch(permissions.toTypedArray())
    }
}
