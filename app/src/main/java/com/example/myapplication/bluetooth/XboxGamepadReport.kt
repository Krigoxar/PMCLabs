package com.example.myapplication.bluetooth

class InputReportNative {

    init {
        System.loadLibrary("native_input_report")
    }

    fun setField(fieldName: String, value: Int) {
        setFieldNative(fieldName, value)
    }

    fun getField(fieldName: String): Int {
        return getFieldNative(fieldName)
    }

    external fun toByteArray(): ByteArray
    external fun setButtonState(buttonIndex: Int, pressed: Boolean)

    private external fun setFieldNative(fieldName: String, value: Int)
    private external fun getFieldNative(fieldName: String): Int
}