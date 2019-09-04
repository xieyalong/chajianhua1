package xyl.biao_zhuan_library;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * 插件化apk的加载类，用来加载第三方插件apk的资源
 * 来加载dex
 * dex文件：包括apk和library
 */
public class BiaoZhunManger {
    public  static  BiaoZhunManger biaoZhunManger;
    //插件apk中的资源对象
    private Resources resources;
    //类加载器，用于加载apk中的类
    private DexClassLoader dexClassLoader;
    private Context context;
    //插件apk中的包信息类
    private PackageInfo packageInfo;

    private  BiaoZhunManger(){}
    public  static  BiaoZhunManger getInstance(){
        if (null==biaoZhunManger){
            biaoZhunManger=new BiaoZhunManger();
        }
        return  biaoZhunManger;
    }

    /**
     *加载插件apk
     */
    public  void loadPath(String path){
        try {
            //获取当前应用内部私有存储路径
            File file=context.getDir("dex",Context.MODE_PRIVATE);
            //初始化类加载器
            dexClassLoader=new DexClassLoader(path,file.getAbsolutePath(),null,context.getClassLoader());
            //获取到包管理器，获取插件apk包的信息
            PackageManager packageManager=context.getPackageManager();
            packageInfo=packageManager.getPackageArchiveInfo(path,PackageManager.GET_ACTIVITIES);


            AssetManager assetManager=AssetManager.class.newInstance();
            Method addAssetPath= assetManager.getClass().getMethod("addAssetPath",String.class);
            addAssetPath.invoke(assetManager,path);
            resources=new Resources(assetManager,context.getResources().getDisplayMetrics(),context.getResources().getConfiguration());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

//    public void setDexClassLoader(DexClassLoader dexClassLoader) {
//        this.dexClassLoader = dexClassLoader;
//    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }
}
