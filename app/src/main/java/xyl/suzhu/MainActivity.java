package xyl.suzhu;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import xyl.biao_zhuan_library.BiaoZhunManger;
import xyl.biao_zhuan_library.DaiLiActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void loadApk(View view){
        loadApk();
    }
    public void  loadApk(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE},1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        BiaoZhunManger.getInstance().setContext(this);
        //chajianapk-debug.apk放在根目录
        String apkPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/chajianapk-debug.apk";
//        String apkPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/com.ayansoft.androphp_3.apk";
        BiaoZhunManger.getInstance().loadPath(apkPath);
    }

    public void jumpActivity(View view) {
        //不管哪个插件apk都跳转到代理apk，这是所有插件apk主入口，
        Intent intent=new Intent(this, DaiLiActivity.class);
        //拿到插件apk中的activity
        String apkMainActivity=BiaoZhunManger.getInstance().getPackageInfo().activities[0].name;
        intent.putExtra("className",apkMainActivity);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
