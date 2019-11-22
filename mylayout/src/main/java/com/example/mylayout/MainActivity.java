package com.example.mylayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CompounView mComView;
    private int i;
    private CompoundText mComtext;
    private ImageView mHeaderLeftImg;
    /**
     * title
     */
    private TextView mHeaderCenterText;
    private ImageView mHeaderRightImg;
    private CompoundText mText;
    private MyText mMyyv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {


    }
}


