package com.example.myapplication.bluetooth

object JoystickDescriptorsCollction
{
    val JOYSTICK_DESCRIPTOR_XBOX360 = byteArrayOf(
    0x05.toByte(), 0x01.toByte(),       //  (GLOBAL) USAGE_PAGE         0x0001 Generic Desktop Page
    0x09.toByte(), 0x05.toByte(),       //  (LOCAL)  USAGE              0x00010005 Game Pad (Application Collection)
    0xA1.toByte(), 0x01.toByte(),       //  (MAIN)   COLLECTION         0x01 Application (Usage=0x00010005: Page=Generic Desktop Page, Usage=Game Pad, Type=Application Collection)
    0xA1.toByte(), 0x00.toByte(),       //    (MAIN)   COLLECTION         0x00 Physical (Usage=0x0: Page=, Usage=, Type=) <-- Error: COLLECTION must be preceded by a known USAGE <-- Warning: USAGE type should be CP (Physical Collection)
    0x09.toByte(), 0x30.toByte(),       //      (LOCAL)  USAGE              0x00010030 X (Dynamic Value)
    0x09.toByte(), 0x31.toByte(),       //      (LOCAL)  USAGE              0x00010031 Y (Dynamic Value)
    0x15.toByte(), 0x00.toByte(),       //      (GLOBAL) LOGICAL_MINIMUM    0x00 (0)  <-- Info: Consider replacing 15 00 with 14
    0x26.toByte(), 0xFF.toByte(), 0xFF.toByte(),    //      (GLOBAL) LOGICAL_MAXIMUM    0xFFFF (-1)  <-- Info: Consider replacing 26 FFFF with 25 FF
    0x35.toByte(), 0x00.toByte(),       //      (GLOBAL) PHYSICAL_MINIMUM   0x00 (0)  <-- Info: Consider replacing 35 00 with 34
    0x46.toByte(), 0xFF.toByte(), 0xFF.toByte(),    //      (GLOBAL) PHYSICAL_MAXIMUM   0xFFFF (-1)  <-- Info: Consider replacing 46 FFFF with 45 FF
    0x95.toByte(), 0x02.toByte(),       //      (GLOBAL) REPORT_COUNT       0x02 (2) Number of fields
    0x75.toByte(), 0x10.toByte(),       //      (GLOBAL) REPORT_SIZE        0x10 (16) Number of bits per field
    0x81.toByte(), 0x02.toByte(),       //      (MAIN)   INPUT              0x00000002 (2 fields x 16 bits) 0=Data 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap  <-- Error: LOGICAL_MAXIMUM (-1) is less than LOGICAL_MINIMUM (0) <-- Error: PHYSICAL_MAXIMUM (-1) is less than PHYSICAL_MINIMUM (0)
    0xC0.toByte(),                      //    (MAIN)   END_COLLECTION     Physical  <-- Warning: Physical units are still in effect PHYSICAL(MIN=0,MAX=-1) UNIT(0x,EXP=0)
    0xA1.toByte(), 0x00.toByte(),       //    (MAIN)   COLLECTION         0x00 Physical (Usage=0x0: Page=, Usage=, Type=) <-- Error: COLLECTION must be preceded by a known USAGE <-- Warning: USAGE type should be CP (Physical Collection)
    0x09.toByte(), 0x33.toByte(),       //      (LOCAL)  USAGE              0x00010033 Rx (Dynamic Value)
    0x09.toByte(), 0x34.toByte(),       //      (LOCAL)  USAGE              0x00010034 Ry (Dynamic Value)
    0x15.toByte(), 0x00.toByte(),       //      (GLOBAL) LOGICAL_MINIMUM    0x00 (0) <-- Redundant: LOGICAL_MINIMUM is already 0 <-- Info: Consider replacing 15 00 with 14
    0x26.toByte(), 0xFF.toByte(), 0xFF.toByte(),    //      (GLOBAL) LOGICAL_MAXIMUM    0xFFFF (-1) <-- Redundant: LOGICAL_MAXIMUM is already -1 <-- Info: Consider replacing 26 FFFF with 25 FF
    0x35.toByte(), 0x00.toByte(),       //      (GLOBAL) PHYSICAL_MINIMUM   0x00 (0) <-- Redundant: PHYSICAL_MINIMUM is already 0 <-- Info: Consider replacing 35 00 with 34
    0x46.toByte(), 0xFF.toByte(), 0xFF.toByte(),    //      (GLOBAL) PHYSICAL_MAXIMUM   0xFFFF (-1) <-- Redundant: PHYSICAL_MAXIMUM is already -1 <-- Info: Consider replacing 46 FFFF with 45 FF
    0x95.toByte(), 0x02.toByte(),       //      (GLOBAL) REPORT_COUNT       0x02 (2) Number of fields <-- Redundant: REPORT_COUNT is already 2
    0x75.toByte(), 0x10.toByte(),       //      (GLOBAL) REPORT_SIZE        0x10 (16) Number of bits per field <-- Redundant: REPORT_SIZE is already 16
    0x81.toByte(), 0x02.toByte(),       //      (MAIN)   INPUT              0x00000002 (2 fields x 16 bits) 0=Data 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap  <-- Error: LOGICAL_MAXIMUM (-1) is less than LOGICAL_MINIMUM (0) <-- Error: PHYSICAL_MAXIMUM (-1) is less than PHYSICAL_MINIMUM (0)
    0xC0.toByte(),                      //    (MAIN)   END_COLLECTION     Physical  <-- Warning: Physical units are still in effect PHYSICAL(MIN=0,MAX=-1) UNIT(0x,EXP=0)
    0x05.toByte(), 0x01.toByte(),       //    (GLOBAL) USAGE_PAGE         0x0001 Generic Desktop Page <-- Redundant: USAGE_PAGE is already 0x0001
    0x09.toByte(), 0x32.toByte(),       //    (LOCAL)  USAGE              0x00010032 Z (Dynamic Value)
    0x15.toByte(), 0x00.toByte(),       //    (GLOBAL) LOGICAL_MINIMUM    0x00 (0) <-- Redundant: LOGICAL_MINIMUM is already 0 <-- Info: Consider replacing 15 00 with 14
    0x26.toByte(), 0xFF.toByte(), 0x00.toByte(),    //    (GLOBAL) LOGICAL_MAXIMUM    0x00FF (255)
    0x95.toByte(), 0x01.toByte(),       //    (GLOBAL) REPORT_COUNT       0x01 (1) Number of fields
    0x75.toByte(), 0x08.toByte(),       //    (GLOBAL) REPORT_SIZE        0x08 (8) Number of bits per field
    0x81.toByte(), 0x02.toByte(),       //    (MAIN)   INPUT              0x00000002 (1 field x 8 bits) 0=Data 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap  <-- Error: PHYSICAL_MAXIMUM (-1) is less than PHYSICAL_MINIMUM (0)
    0x05.toByte(), 0x01.toByte(),       //    (GLOBAL) USAGE_PAGE         0x0001 Generic Desktop Page <-- Redundant: USAGE_PAGE is already 0x0001
    0x09.toByte(), 0x35.toByte(),       //    (LOCAL)  USAGE              0x00010035 Rz (Dynamic Value)
    0x15.toByte(), 0x00.toByte(),       //    (GLOBAL) LOGICAL_MINIMUM    0x00 (0) <-- Redundant: LOGICAL_MINIMUM is already 0 <-- Info: Consider replacing 15 00 with 14
    0x26.toByte(), 0xFF.toByte(), 0x00.toByte(),    //    (GLOBAL) LOGICAL_MAXIMUM    0x00FF (255) <-- Redundant: LOGICAL_MAXIMUM is already 255
    0x95.toByte(), 0x01.toByte(),       //    (GLOBAL) REPORT_COUNT       0x01 (1) Number of fields <-- Redundant: REPORT_COUNT is already 1
    0x75.toByte(), 0x08.toByte(),       //    (GLOBAL) REPORT_SIZE        0x08 (8) Number of bits per field <-- Redundant: REPORT_SIZE is already 8
    0x81.toByte(), 0x02.toByte(),       //    (MAIN)   INPUT              0x00000002 (1 field x 8 bits) 0=Data 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap  <-- Error: PHYSICAL_MAXIMUM (-1) is less than PHYSICAL_MINIMUM (0)
    0x05.toByte(), 0x09.toByte(),       //    (GLOBAL) USAGE_PAGE         0x0009 Button Page
    0x19.toByte(), 0x01.toByte(),       //    (LOCAL)  USAGE_MINIMUM      0x00090001 Button 1 Primary/trigger (Selector, On/Off Control, Momentary Control, or One Shot Control)
    0x29.toByte(), 0x0A.toByte(),       //    (LOCAL)  USAGE_MAXIMUM      0x0009000A Button 10 (Selector, On/Off Control, Momentary Control, or One Shot Control)
    0x95.toByte(), 0x0A.toByte(),       //    (GLOBAL) REPORT_COUNT       0x0A (10) Number of fields
    0x75.toByte(), 0x01.toByte(),       //    (GLOBAL) REPORT_SIZE        0x01 (1) Number of bits per field
    0x81.toByte(), 0x02.toByte(),       //    (MAIN)   INPUT              0x00000002 (10 fields x 1 bit) 0=Data 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap  <-- Error: REPORT_SIZE (1) is too small for LOGICAL_MAXIMUM (255) which needs 8 bits. <-- Error: PHYSICAL_MAXIMUM (-1) is less than PHYSICAL_MINIMUM (0)
    0x05.toByte(), 0x01.toByte(),       //    (GLOBAL) USAGE_PAGE         0x0001 Generic Desktop Page
    0x09.toByte(), 0x39.toByte(),       //    (LOCAL)  USAGE              0x00010039 Hat switch (Dynamic Value)
    0x15.toByte(), 0x01.toByte(),       //    (GLOBAL) LOGICAL_MINIMUM    0x01 (1)
    0x25.toByte(), 0x08.toByte(),       //    (GLOBAL) LOGICAL_MAXIMUM    0x08 (8)
    0x35.toByte(), 0x00.toByte(),       //    (GLOBAL) PHYSICAL_MINIMUM   0x00 (0) <-- Redundant: PHYSICAL_MINIMUM is already 0 <-- Info: Consider replacing 35 00 with 34
    0x46.toByte(), 0x3B.toByte(), 0x10.toByte(),    //    (GLOBAL) PHYSICAL_MAXIMUM   0x103B (4155)
    0x66.toByte(), 0x0E.toByte(), 0x00.toByte(),    //    (GLOBAL) UNIT               0x000E  (E=Reserved <-- Error: Measurement system type (E) is reserved)  <-- Info: Consider replacing 66 0E00 with 65 0E
    0x75.toByte(), 0x04.toByte(),       //    (GLOBAL) REPORT_SIZE        0x04 (4) Number of bits per field
    0x95.toByte(), 0x01.toByte(),       //    (GLOBAL) REPORT_COUNT       0x01 (1) Number of fields
    0x81.toByte(), 0x42.toByte(),       //    (MAIN)   INPUT              0x00000042 (1 field x 4 bits) 0=Data 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 1=Null 0=NonVolatile 0=Bitmap
    0x75.toByte(), 0x02.toByte(),       //    (GLOBAL) REPORT_SIZE        0x02 (2) Number of bits per field
    0x95.toByte(), 0x01.toByte(),       //    (GLOBAL) REPORT_COUNT       0x01 (1) Number of fields <-- Redundant: REPORT_COUNT is already 1
    0x81.toByte(), 0x03.toByte(),       //    (MAIN)   INPUT              0x00000003 (1 field x 2 bits) 1=Constant 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap
    0x75.toByte(), 0x08.toByte(),       //    (GLOBAL) REPORT_SIZE        0x08 (8) Number of bits per field
    0x95.toByte(), 0x02.toByte(),       //    (GLOBAL) REPORT_COUNT       0x02 (2) Number of fields
    0x81.toByte(), 0x03.toByte(),       //    (MAIN)   INPUT              0x00000003 (2 fields x 8 bits) 1=Constant 1=Variable 0=Absolute 0=NoWrap 0=Linear 0=PrefState 0=NoNull 0=NonVolatile 0=Bitmap
    0xC0.toByte()
    )
}