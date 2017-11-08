APP_CFLAGS += -Wno-error=format-security

#opencv 配置需要
APP_STL:=gnustl_static
APP_CPPFLAGS:=-frtti -fexceptions

APP_ABI := armeabi,armeabi-v7a,arm64-v8a