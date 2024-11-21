#include <cstdint>
#include <jni.h>
#include <cstring>

struct InputReport {
    uint16_t gamePadX = UINT16_MAX / 2;
    uint16_t gamePadY = UINT16_MAX / 2;
    uint16_t gamePadRx = UINT16_MAX / 2;
    uint16_t gamePadRy = UINT16_MAX / 2;
    uint8_t gamePadZ = UINT8_MAX / 2;
    uint8_t gamePadRz = UINT8_MAX / 2;
    uint16_t buttons = 0;
    uint8_t hatSwitch = 0;

    void toByteArray(uint8_t* buffer) const {
        buffer[0] = gamePadX & 0xFF;
        buffer[1] = (gamePadX >> 8) & 0xFF;
        buffer[2] = gamePadY & 0xFF;
        buffer[3] = (gamePadY >> 8) & 0xFF;
        buffer[4] = gamePadRx & 0xFF;
        buffer[5] = (gamePadRx >> 8) & 0xFF;
        buffer[6] = gamePadRy & 0xFF;
        buffer[7] = (gamePadRy >> 8) & 0xFF;
        buffer[8] = gamePadZ;
        buffer[9] = gamePadRz;
        buffer[10] = buttons & 0xFF;
        buffer[11] = (buttons >> 8) & 0x03;
        buffer[12] = (hatSwitch & 0x0F) | 0xF0;
        buffer[13] = 0x00;
        buffer[14] = 0x00;
    }

    void setButtonState(int buttonIndex, bool pressed) {
        if (buttonIndex >= 1 && buttonIndex <= 10) {
            uint16_t mask = 1 << (buttonIndex - 1);
            if (pressed) {
                buttons |= mask;
            } else {
                buttons &= ~mask;
            }
        }
    }
};

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_example_myapplication_bluetooth_InputReportNative_toByteArray(JNIEnv* env, jobject obj) {
    InputReport report;

    // Создаем массив байтов
    uint8_t buffer[15];
    report.toByteArray(buffer);

    // Преобразуем массив в jbyteArray
    jbyteArray byteArray = env->NewByteArray(15);
    env->SetByteArrayRegion(byteArray, 0, 15, reinterpret_cast<jbyte*>(buffer));
    return byteArray;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_bluetooth_InputReportNative_setButtonState(JNIEnv* env, jobject obj, jint buttonIndex, jboolean pressed) {
    InputReport report;
    report.setButtonState(buttonIndex, pressed);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_bluetooth_InputReportNative_setFieldNative(JNIEnv *env, jobject thiz,
                                                                          jstring field_name,
                                                                          jint value) {
    const char* field = env->GetStringUTFChars(field_name, nullptr);
    InputReport report;

    if (strcmp(field, "gamePadX") == 0) {
        report.gamePadX = static_cast<uint16_t>(value);
    } else if (strcmp(field, "gamePadY") == 0) {
        report.gamePadY = static_cast<uint16_t>(value);
    } else if (strcmp(field, "gamePadRx") == 0) {
        report.gamePadRx = static_cast<uint16_t>(value);
    } else if (strcmp(field, "gamePadRy") == 0) {
        report.gamePadRy = static_cast<uint16_t>(value);
    } else if (strcmp(field, "gamePadZ") == 0) {
        report.gamePadZ = static_cast<uint8_t>(value);
    } else if (strcmp(field, "gamePadRz") == 0) {
        report.gamePadRz = static_cast<uint8_t>(value);
    } else if (strcmp(field, "buttons") == 0) {
        report.buttons = static_cast<uint16_t>(value);
    } else if (strcmp(field, "hatSwitch") == 0) {
        report.hatSwitch = static_cast<uint8_t>(value);
    }

    env->ReleaseStringUTFChars(field_name, field);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_myapplication_bluetooth_InputReportNative_getFieldNative(JNIEnv *env, jobject thiz,
                                                                          jstring field_name) {
    const char* field = env->GetStringUTFChars(field_name, nullptr);
    jint value = 0;
    InputReport report;

    if (strcmp(field, "gamePadX") == 0) {
        value = report.gamePadX;
    } else if (strcmp(field, "gamePadY") == 0) {
        value = report.gamePadY;
    } else if (strcmp(field, "gamePadRx") == 0) {
        value = report.gamePadRx;
    } else if (strcmp(field, "gamePadRy") == 0) {
        value = report.gamePadRy;
    } else if (strcmp(field, "gamePadZ") == 0) {
        value = report.gamePadZ;
    } else if (strcmp(field, "gamePadRz") == 0) {
        value = report.gamePadRz;
    } else if (strcmp(field, "buttons") == 0) {
        value = report.buttons;
    } else if (strcmp(field, "hatSwitch") == 0) {
        value = report.hatSwitch;
    }

    env->ReleaseStringUTFChars(field_name, field);
    return value;
}