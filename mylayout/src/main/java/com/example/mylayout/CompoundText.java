package com.example.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2118:31
 * desc   :
 * package: Text:
 */
public class CompoundText extends RelativeLayout {

    private ImageView imaLeft;
    private ImageView imaright;
    private TextView text;
    private RelativeLayout relav;
    private Context context;

    public CompoundText(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public CompoundText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);
        String string = typedArray.getString(R.styleable.HeaderBar_title_text);
        if (!TextUtils.isEmpty(string)) {
            text.setText(string);
        }
        int anInt = typedArray.getInt(R.styleable.HeaderBar_show_views, 0x26);
        text.setTextColor(typedArray.getColor(R.styleable.HeaderBar_title_text_color,Color.WHITE));
        typedArray.recycle();
        showView(anInt);
    }

    private void showView(int showView) {
        Long aLong = Long.valueOf(Integer.toBinaryString(showView));
        String $06d = String.format("$06d", aLong);
        for (int i = 0; i < $06d.length(); i++) {
            if (i == 0) {

            }
            if (i == 1) {
                text.setVisibility($06d.substring(i, i + 1).equals(1) ? View.VISIBLE : View.GONE);
            }
            if (i == 2) {
                imaLeft.setVisibility($06d.substring(i,i+1).equals("1")? View.VISIBLE:View.GONE);
            }
            if (i == 3) {

            }
        }
    }

    public CompoundText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.text_layout, this, true);
        imaLeft = (ImageView) findViewById(R.id.header_left_img);
        imaright = (ImageView) findViewById(R.id.header_right_img);
        text = (TextView) findViewById(R.id.header_center_text);
        relav = findViewById(R.id.root_view);
        relav.setBackgroundColor(Color.BLACK);
        text.setTextColor(Color.WHITE);
    }

    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            text.setText(title);
        }
    }

    public void setLefeListener(OnClickListener onClickListener) {
        imaLeft.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        imaright.setOnClickListener(onClickListener);
    }
}
