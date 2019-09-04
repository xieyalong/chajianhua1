package xyl.biao_zhuan_library;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 代理activity，就是一个壳子，加载到第三方插件apk中的activity
 */
public class DaiLiActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            //通过反射去把插件apk对象化,因为这里插件apk整个都是死的
            //拿到插件apk的mainactivity
            String className=getIntent().getStringExtra("className");
            //插件apk中的activity的类对象
           Class<?> aClass=BiaoZhunManger.getInstance().getDexClassLoader().loadClass(className);
            Object newInstance=aClass.newInstance();
            //是否符合我们的标准
            if (newInstance instanceof  BiaoZhunInterface){
                //面向接口：用接口的实例实现一个类对象
                BiaoZhunInterface biaoZhunInterface=(BiaoZhunInterface)newInstance;
                //把上下文传给插件的上下文
                biaoZhunInterface.attach(this);
                //调用插件apk中的activity
                Bundle bundle=new Bundle();
                biaoZhunInterface.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void startActivity(Intent intent) {
        String className=intent.getStringExtra("className");
        Intent m=new Intent(this,DaiLiActivity.class);
//        System.out.println("插件apk>]className="+intent.getComponent().getClassName());
        m.putExtra("className",className);
        super.startActivity(m);
    }

    @Override
    public Resources getResources() {
        return BiaoZhunManger.getInstance().getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return BiaoZhunManger.getInstance().getDexClassLoader();
    }
}
