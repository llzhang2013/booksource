package com.example.zhanglili.zlltestfirstcode.chapter10_service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.zhanglili.zlltestfirstcode.MainActivity;
import com.example.zhanglili.zlltestfirstcode.R;

public class MyService extends Service {
    private static final String TAG = "MyService";

    private DownloadBinder binder = new DownloadBinder();//私有变量 外部可以通过类访问


    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d(TAG, "startDownload: ");
        }

        public void getProgress(){
            Log.d(TAG, "getProgress: ");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {

        return  binder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");


        //使变为前台服务  TODO 这里也可以使用this
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,1,intent,0);
        Notification notification =new NotificationCompat.Builder(this,"default")
                .setContentTitle("测试notification")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);
        super.onCreate();



    }

    @Override//绑定的话这个不走
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);

    }



    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }








}
