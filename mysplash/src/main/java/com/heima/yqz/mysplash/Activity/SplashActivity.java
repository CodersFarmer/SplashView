package com.heima.yqz.mysplash.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.heima.yqz.mysplash.R;

/**
 * Created by Mryang on 2017/1/29.
 * Email：
 * Content：一个可以跳过的闪屏界面
 */

public class SplashActivity extends AppCompatActivity {
    private static final int ENTER_MAINACTIVITY = 1;
    //主线程的handler
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ENTER_MAINACTIVITY:
                    /**
                     * 进入主界面
                     * */
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
    private TextView myTv;
    //控制按钮样式是否改变
    private boolean tag = true;
    //每次验证请求需要间隔5S
    private int i=6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.sendEmptyMessageDelayed(ENTER_MAINACTIVITY, 5000);
        myTv = (TextView) findViewById(R.id.tv_register_sms_call);
        changeBtnGetCode();
        myTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                handler.removeCallbacksAndMessages(null);
                finish();
            }
        });
    }
    private void changeBtnGetCode() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (tag) {
                    while (i > 0) {
                        i--;
                        //如果活动为空
                        if (SplashActivity.this == null) {
                            break;
                        }
                        //更新UI的操作，放到UI线程
                        SplashActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myTv.setText("跳过" + i + "S");
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread.start();
    }
}
