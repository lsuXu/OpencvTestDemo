package com.example.a12852.opencvtestdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CarLayoutView extends View {

    private static final String TAG = "ObjectRectView";

    private Paint mPntLine = null;
    private Bitmap mlayout;

    public CarLayoutView(Context context) {
        super(context);
        initialize();
    }

    public CarLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public CarLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        mPntLine = new Paint();
        mPntLine.setStyle(Paint.Style.FILL);
        mPntLine.setColor(0xff0000ff);
        mPntLine.setStrokeWidth(5f);
    }

    public void setLayoutData(Bitmap layout) {
       this.mlayout = layout;
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Log.i("dji_carLayout","--layout:" + mlayout);
        if(mlayout != null) {
            c.drawBitmap(mlayout, 0, 0, new Paint(Paint.ANTI_ALIAS_FLAG));
        }
    }
}
