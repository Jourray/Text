package com.example.mylayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2210:39
 * desc   :
 * package: Text:
 */
public class MyText extends View {

    private Paint paint;
    Context context;

    public MyText(Context context) {
        super(context);
        this.context=context;
        initView(context);
    }

    private void initView(Context context) {
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    public MyText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView(context);
    }

    public void setText(String title) {
        if (!TextUtils.isEmpty(title)){

        }
    }

    public MyText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        paint.setColor(Color.BLUE);
        RectF rectF = new RectF(0, 0, width, height);
        canvas.drawRect(rectF, paint);
        paint.setColor(Color.BLACK);
        canvas.drawLine(0, height / 2, width, height / 2, paint);

    }
}
