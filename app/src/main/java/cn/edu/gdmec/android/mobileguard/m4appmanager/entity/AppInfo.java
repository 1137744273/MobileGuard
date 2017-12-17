package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by milku on 2017/11/11.
 */

public class AppInfo {
    public String packageName;
    public Drawable icon;
    public String appName;
    public String apkPath;
    public long appSize;
    public boolean isUserApp;
    public boolean isInRoom;
    public boolean isSelected = false;
    public String getAppLocation(boolean isInRoom){
        if (isInRoom){
            return "手机内存";
        }else{
            return "外部存储";
        }
    }
    /*应用程序是否加锁*/
    public boolean isLock;
}
