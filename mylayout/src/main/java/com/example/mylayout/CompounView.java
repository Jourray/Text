package com.example.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2117:21
 * desc   :
 * package: Text:
 */
public class CompounView extends LinearLayout {
    private int max = 100;
    private int progress = 0;

    Context context;
    private ProgressBar pro;
    private Button bt;

    public CompounView(Context context) {
        super(context);
        initView(context);
    }

    public void setMax(int max) {
        this.max = max;
        pro.setProgress(max);
    }

    public void setProgress(int progress) {
        if (progress > max) {
            this.progress = max;
        } else {
            this.progress = progress;
        }
        pro.setProgress(this.progress);
    }

    public void setBtnCancelListener(OnClickListener onClickListener) {
        bt.setOnClickListener(onClickListener);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.progress_layout, this);
        pro = view.findViewById(R.id.pro);
        bt = view.findViewById(R.id.bt);
    }

    public CompounView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CompounView);
        typedArray.getInt(R.styleable.CompounView_max, 100);
        typedArray.getInt(R.styleable.CompounView_progress, 10);
        typedArray.recycle();

    }

    public CompounView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        pro.setMax(max);
        pro.setProgress(progress);
    }


}
