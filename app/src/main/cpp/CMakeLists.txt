cmake_minimum_required(VERSION 3.4.1)

add_library(
        native_lib
        SHARED
        native_lib.cpp
)

find_library(
        log-lib
        NAMES log
        PATHS ${ANDROID_NDK}/sources/cxx-stl/system/lib
)
