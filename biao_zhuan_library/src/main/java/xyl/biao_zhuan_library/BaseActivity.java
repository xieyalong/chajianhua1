package xyl.biao_zhuan_library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 实现BiaoZhunInterface报红线不用管它
 */
public abstract class BaseActivity extends Activity implements  BiaoZhunInterface{

 protected  Activity that;

 @Override
 public void attach(Activity activity) {
  this.that=activity;
 }

 @Override
 public void onCreate(Bundle savedInstanceState) {

 }

 @Override
 public void onStart() {

 }

 @Override
 public void onResume() {

 }

 @Override
 public void onPause() {

 }

 @Override
 public void onStop() {

 }

 @Override
 public void onDestroy() {

 }
// @Override
// public void onBack() {
//  that.onBackPressed();
// }

 @Override
 public void onSaveInstanceState(Bundle savedInstanceState) {

 }

 @Override
 public void onPointerCaptureChanged(boolean hasCapture) {

 }

 @Override
 public void setContentView(View view) {
  that.setContentView(view);
 }

 @Override
 public <T extends View> T findViewById(int id) {
  return that.findViewById(id);
 }

 @Override
 public void startActivity(Intent intent) {
  Intent m=new Intent();
  System.out.println("插件apk>]className="+intent.getComponent().getClassName());
  m.putExtra("className",intent.getComponent().getClassName());
  that.startActivity(m);
 }

 @Override
 public Intent getIntent() {
  return that.getIntent();
 }

 @Override
 public ClassLoader getClassLoader() {
  return that.getClassLoader();
 }

 @Override
 public LayoutInflater getLayoutInflater() {
  return that.getLayoutInflater();
 }

 @Override
 public Window getWindow() {
  return that.getWindow();
 }

 @Override
 public WindowManager getWindowManager() {
  return that.getWindowManager();
 }
// public    void onTouchEvent(MotionEvent event){
//  that.onTouchEvent(event);
// }


}
