package com.example.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.bluetooth.InputReportNative

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InputReportTest {
    @Test
    fun TryWriteToStruct() {
        // Context of the app under test.
        val JoystickReport = InputReportNative()

        JoystickReport.setField("gamePadX", 1)

        assertEquals(JoystickReport.getField("gamePadX"), 1)
    }

    @Test
    fun ReportIsChenging() {
        // Context of the app under test.
        val JoystickReport = InputReportNative()

        val FirstDefaultReport = JoystickReport.toByteArray()

        JoystickReport.setField("gamePadX", 1)

        val SecondDefaultReport = JoystickReport.toByteArray()

        assertNotEquals(FirstDefaultReport, SecondDefaultReport)
    }
}