package com.example.myapplication.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothHidDevice
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlin.random.Random

@SuppressLint("MissingPermission")
@RequiresApi(Build.VERSION_CODES.P)
open class XboxJoystickSender(val hidDevice: BluetoothHidDevice, val host: BluetoothDevice)
{
    val JoystickReport = InputReportNative()

    open fun sendReport()
    {
        hidDevice.sendReport(host, 0, JoystickReport.toByteArray())
    }

    open fun SendRandomShit()
    {
        val bytes = ByteArray(13)
        Random.nextBytes(bytes)
        hidDevice.sendReport(host, 0, bytes)
    }
}