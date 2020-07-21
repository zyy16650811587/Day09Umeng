package com.example.day09umeng.base;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * @date：2020/7/16
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {

        //58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        UMConfigure.init(this,"5f0fb7b6dbc2ec08135612d1"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setSinaWeibo("3836498157", "8ec8398c11fd7b528255f12827da06da","http://sns.whalecloud.com");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setAlipay("2015111700822536");
        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
        PlatformConfig.setPinterest("1439206");
        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setVKontakte("5764965","5My6SNliAaLxEm3Lyd9J");
        PlatformConfig.setDropbox("oz8v5apet3arcdy","h7p2pjbzkkxt02a");
        super.onCreate();
    }
}
