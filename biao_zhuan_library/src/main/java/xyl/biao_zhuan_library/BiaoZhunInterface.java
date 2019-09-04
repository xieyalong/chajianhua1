package xyl.biao_zhuan_library;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * 所有插件apk的activity必须要要实现的接口类
 * 是规范所有插件apk的activity标准，面向接口开发
 */
public interface BiaoZhunInterface {
    void attach(Activity activity);
    void onCreate(Bundle savedInstanceState);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
//    void onBack();
//    void onTouchEvent(MotionEvent event);
    void  onSaveInstanceState(Bundle savedInstanceState);
}
