package com.ilmal08.kmptemplate.util

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVCaptureDeviceInput
import platform.AVFoundation.AVCaptureDevicePositionBack
import platform.AVFoundation.AVCaptureSession
import platform.AVFoundation.AVCaptureSessionPresetPhoto
import platform.AVFoundation.AVCaptureStillImageOutput
import platform.AVFoundation.AVCaptureVideoPreviewLayer
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.AVVideoCodecJPEG
import platform.AVFoundation.AVVideoCodecKey
import platform.AVFoundation.position
import platform.CoreGraphics.CGRect
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun CameraInterface() {
    // Find the back camera device
    val device = AVCaptureDevice.devicesWithMediaType(AVMediaTypeVideo).firstOrNull { device ->
        (device as? AVCaptureDevice)?.position == AVCaptureDevicePositionBack
    } as? AVCaptureDevice

    if (device == null) {
        // Handle the case where no back camera is available
        Text("No back camera available")
        return
    }

    // Create input from the device
    val input = try {
        AVCaptureDeviceInput.deviceInputWithDevice(device, null) as? AVCaptureDeviceInput
    } catch (e: Throwable) {
        // Handle the error in input creation
        Text("Error creating camera input: ${e.message}")
        return
    }

    // Create the output
    val output = AVCaptureStillImageOutput().apply {
        outputSettings = mapOf(AVVideoCodecKey to AVVideoCodecJPEG)
    }

    // Create the session and configure it
    val session = AVCaptureSession().apply {
        sessionPreset = AVCaptureSessionPresetPhoto
        if (input != null) {
            addInput(input)
        }
        addOutput(output)
    }

    // Create the preview layer
    val cameraPreviewLayer = remember { AVCaptureVideoPreviewLayer(session = session) }

    // Set up the UIKit view
    UIKitView(
        modifier = Modifier.fillMaxSize(),
        background = Color.Black,
        factory = {
            val container = UIView().apply {
                layer.addSublayer(cameraPreviewLayer)
            }
            cameraPreviewLayer.videoGravity = AVLayerVideoGravityResizeAspectFill
            session.startRunning()
            container
        },
        onResize = { container: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            container.layer.setFrame(rect)
            cameraPreviewLayer.setFrame(rect)
            CATransaction.commit()
        }
    )
}