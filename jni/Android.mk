LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

#加载相关opencv so库
#自动将依赖的opencv库拷贝到lib目录下，只对OPENCV_CAMERA_MODULES有效，当其为on时拷贝
OpenCV_INSTALL_MODULES:=on
OPENCV_CAMERA_MODULES:=off

OPENCV_LIB_TYPE:=STATIC
ifeq ("$(wildcard $(OPENCV_MK_PATH))","")
include D:\OpenCV-android-sdk\sdk\native\jni\OpenCV.mk
else
include $(OPENCV_MK_PATH)
endif

LOCAL_MODULE    := testJNI
LOCAL_SRC_FILES := NativeHelp.cpp


#opencv配置需要。替换LOCAL_LDLIBS:=-L$(SYSROOT)/usr/lib -llog
LOCAL_LDLIBS += -lm -llog

include $(BUILD_SHARED_LIBRARY)