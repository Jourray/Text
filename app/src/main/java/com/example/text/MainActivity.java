package com.example.text;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * Hello World!
     */
    private TextView mTv;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
       // initSystemRuning();
    }

    private void initData() {

        RequestParams requestParams = new RequestParams("https://www.jiansport.com/sports-rest-test/tmVenueMemberController/postVenueMemberInfo?");
        requestParams.addBodyParameter("imgUrl","https://qiniu.jiansport.com/15743478409939611.jpg");
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+ toString().toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d(TAG, "onError: "+ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initSystemRuning() {
        RequestParams requestParams = new RequestParams("https://tcsales.189.cn/sales-login/accessPermission");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                AdverReturn adverReturn = new JSONUtil<String, AdverReturn>().JsonStrToObject(s, AdverReturn.class);
                String respDesc = adverReturn.getRespDesc();
                if (respDesc.equals("系统正常运行")) {
                    // ToastUtils.showToast(MyApplication.getContext(), respDesc);
                    Toast.makeText(MainActivity.this, respDesc, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, respDesc, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.d(TAG, "onError: " + throwable.getMessage());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}

