package com.example.a12852.opencvtestdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a12852.opencvtestdemo.entity.Student;
import com.example.a12852.opencvtestdemo.tools.NativeHelp;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static{
        System.loadLibrary("testJNI");
    }
    CarLayoutView carLayoutView;
    CarLayoutView carLayoutView2;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        carLayoutView = (CarLayoutView) findViewById(R.id.CarLayout);
        carLayoutView2 = (CarLayoutView) findViewById(R.id.CarLayout2);
        testJNI();
        bitmapTest();
    }
    private void testJNI(){
        String s = NativeHelp.testString();
        int i = NativeHelp.testInt();
        Log.i("testJNI",s + "----" + i);
        Student student = new Student("Alice您好啊",15);
        String name = NativeHelp.setStudent(student);
        Log.i("testJNI",name);
        Student getStudent = NativeHelp.getStudent();
        Log.i("testJNI",getStudent.toString());
        HashMap<Object,Object> hashMap;
        hashMap = NativeHelp.getHashMap();
        Log.i("testJNI",(String)hashMap.get("apple"));
        Log.i("testJNI",(String)hashMap.get("banana"));
    }

    private void bitmapTest(){
        //从资源目录中获取bitmap对象
        bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.test2))).getBitmap();

        int w =bitmap.getWidth();
        int h = bitmap.getHeight();
        int [] pic = new int[w * h];
        bitmap.getPixels(pic,0,w,0,0,w,h);
        int [] resultPic = NativeHelp.testBitMap(pic,w,h);
        Bitmap res = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
        res.setPixels(resultPic,0,w,0,0,w,h);

        //bitmap转mat
        /*Utils.bitmapToMat(bitmap,mat);
        Mat mat1 = NativeHelp.testMat(mat);
        //进行图像彩色空间转换(原图像，目标图像)
        Imgproc.cvtColor(mat1,mat1,Imgproc.COLOR_RGB2GRAY);
        //mat转bitmat
        Utils.matToBitmap(mat1,bitmap);
        Log.i("opencv_test","width= "+mat1.size().width + "height= " + mat1.size().height);*/
        //将bitmap绘制到图层
        carLayoutView.setLayoutData(res);
        carLayoutView2.setLayoutData(bitmap);
    }

}
