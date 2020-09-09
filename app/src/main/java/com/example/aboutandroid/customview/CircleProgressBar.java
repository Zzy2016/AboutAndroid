package com.example.aboutandroid.customview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author: Administrator
 * @date: 2020/9/9
 */
public class CircleProgressBar extends View {

    private int mInnerBackground = Color.BLUE;
    private int mOuterBackground = Color.RED;

    private int mRoundWidth = 10;
    private float mProgressTextSize = 15;
    private int mProgressTextColor = Color.RED;

    private Paint mInnerPaint, mOuterPaint, mTextPaint;
    private int mMax = 100;
    private int mProgress = 0;

    public CircleProgressBar(Context context) {
        super(context);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
