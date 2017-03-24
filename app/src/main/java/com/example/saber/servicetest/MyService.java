package com.example.saber.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder binder = new DownloadBinder();


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("info", "onCreate()");

        //创建前台服务
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();

        //让MyService变成前台服务
        startForeground(1,notification);




    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("info", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("info", "onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d("info", "startDownload()");
        };

        public int getProgress(){
            Log.d("info", "getProgress() ");
            return 0;
        };
    }






}
