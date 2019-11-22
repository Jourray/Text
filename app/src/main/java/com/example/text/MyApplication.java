package com.example.text;

import android.app.Application;

import org.xutils.x;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/11/2011:40
 * desc   :
 * package: Text:
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
