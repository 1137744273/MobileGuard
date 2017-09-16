package com.me.android.mobileguard.m1home.utils;

import android.app.Activity;

import com.me.android.mobileguard.m1home.entity.VersionEntity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;



public class VersionUpdateUtils {
    private String mVersion;
    private Activity context;
    private VersionEntity versionEntity;

    public VersionUpdateUtils(String version, Activity context) {
        mVersion = version;
        this.context = context;
    }
    public void getCloudVersion(){
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(httpClient.getParams(),5000);
            HttpConnectionParams.setSoTimeout(httpClient.getParams(),5000);
            HttpGet httpGet = new HttpGet("http://android2017.duapp.com/upadte.html");
            HttpResponse execute = httpClient.execute(httpGet);
            if(execute.getStatusLine().getStatusCode()==200);
            HttpEntity httpEntity = execute.getEntity();
            String result = EntityUtils.toString(httpEntity,"utf-8");
            JSONObject jsonObject = new JSONObject(result);
            versionEntity = new VersionEntity();
            versionEntity.versioncode = jsonObject.getString("code");
            versionEntity.description = jsonObject.getString("des");
            versionEntity.apkurl = jsonObject.getString("apkurl");
            if (!mVersion.equals(versionEntity.versioncode)){
                //版本不同，需升级
                System.out.println(versionEntity.description);
                DownLoadUtils downLoadUtils = new DownLoadUtils();
                downLoadUtils.downloadApk(versionEntity.apkurl,"mobileguard.apk",context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
