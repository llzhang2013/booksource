package com.example.zhanglili.zlltestfirstcode.chapter8_notify;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zhanglili.zlltestfirstcode.R;

public class NotifyActivity extends AppCompatActivity {
    private static final String TAG = "KKK-NotifyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        Intent intent = getIntent();
        int  id =intent.getIntExtra("id",0);
        Log.d(TAG, "onCreate:id= "+id);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(id);//TODO 只走一次 没办法点击每个都获得id 而且下面的生命周期都不走
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        int  id =intent.getIntExtra("id",0);
        Log.d(TAG, "onCreate:id= "+id);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(id);
    }

    

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
