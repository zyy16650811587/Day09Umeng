package com.example.day09umeng;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };
    private Button bnt;
    private Button weibo;
    private Button QQ;
    private Button weixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        checkPermiss();

    }

    private void checkPermiss() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    private void initView() {
        bnt = (Button) findViewById(R.id.bnt);

        bnt.setOnClickListener(this);
        bnt = (Button) findViewById(R.id.bnt);
        bnt.setOnClickListener(this);
        weibo = (Button) findViewById(R.id.weibo);
        weibo.setOnClickListener(this);
        QQ = (Button) findViewById(R.id.QQ);
        QQ.setOnClickListener(this);
        weixin = (Button) findViewById(R.id.weixin);
        weixin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnt:
                initData();
                break;
                case R.id.weibo:
                initweibo(SHARE_MEDIA.SINA);
                break;
            case R.id.QQ:
                initQQ(SHARE_MEDIA.QQ);
                break;
            case R.id.weixin:
                initweixin(SHARE_MEDIA.WEIXIN);
                break;
        }
    }

    private void initweixin(SHARE_MEDIA weixin) {
        new ShareAction(MainActivity.this)
                .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                .withText("hello")//分享内容
                .setCallback(umShareListener)//回调监听器
                .share();
    }

    private void initQQ(SHARE_MEDIA qq) {
        new ShareAction(MainActivity.this)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withText("hello")//分享内容
                .setCallback(umShareListener)//回调监听器
                .share();
    }

    private void initweibo(SHARE_MEDIA SINA) {
        new ShareAction(MainActivity.this)
                .setPlatform(SHARE_MEDIA.SINA)//传入平台
                .withText("hello")//分享内容
                .setCallback(umShareListener)//回调监听器
                .share();
    }

    private void initData() {
        new ShareAction(MainActivity.this).withText("大家好!!!!").setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN);
//               h .setCallback(umShareListener).open();
    }
}
