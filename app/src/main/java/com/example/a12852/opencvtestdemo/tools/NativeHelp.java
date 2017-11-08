package com.example.a12852.opencvtestdemo.tools;

import android.graphics.Bitmap;

import com.example.a12852.opencvtestdemo.entity.Student;

import java.util.HashMap;

/**
 * Created by 12852 on 2017/10/30.
 */

public class NativeHelp {
    public static native int testInt();
    //返回字符串
    public static native String testString();
    //传递自定义对象
    public static native String setStudent(Student student);
    //从本地方法中返回特殊自定义对象
    public static native Student getStudent();

    public static native int [] testBitMap(int [] src,int width,int height);

    public static native HashMap getHashMap();

}
