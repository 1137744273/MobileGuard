package  cn.edu.gdmec.android.mobileguard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.edu.gdmec.android.mobileguard.m1home.HomeActivity;
import cn.edu.gdmec.android.mobileguard.m1home.utils.Myutils;


public class SplashActivity extends AppCompatActivity {
    private TextView mTvVersion;
    private String mVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        mVersion = Myutils.getVersion(getApplicationContext());
        mTvVersion = (TextView)findViewById(R.id.tv_splash_version);
        mTvVersion.setText("版本号："+mVersion);

        //final VersionUpdateUtils versionUpdateUtils = new VersionUpdateUtils(mVersion,SplashActivity.this);
/*        new Thread(){
            @Override
            public void run(){
                super.run();
                versionUpdateUtils.getCloudVersion();
                versionUpdateUtils.getCloudVersion("http://android2017.duapp.com/updateinfo.html");
            }
        }.start();*/

        //老师
        startActivity(new Intent (this, HomeActivity.class));
        finish();
    }
}