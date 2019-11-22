package com.example.mylayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2211:28
 * desc   :
 * package: Text:
 */
public class MyView extends View {
    private Paint RectView = new Paint();


    public MyView(Context context) {
        super(context);
        init();
    }

    private void init() {
        RectView.setColor(Color.BLUE);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizewidth = MeasureSpec.getSize(widthMeasureSpec);
        int modewidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int size1Height = MeasureSpec.getSize(heightMeasureSpec);
        if (modewidth == MeasureSpec.AT_MOST && modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, 300);
        } else if (modewidth == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, heightMeasureSpec);
        } else if (modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSpec, 300);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingBottom - paddingTop;
        canvas.drawRect(0 + paddingLeft, 0 + paddingTop, width + paddingLeft, height + paddingTop, RectView);

    }
}
