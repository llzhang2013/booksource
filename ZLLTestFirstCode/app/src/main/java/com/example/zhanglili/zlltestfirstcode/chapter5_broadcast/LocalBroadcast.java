package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;

public class LocalBroadcast extends AppCompatActivity {
    private LocalReceive  localReceive;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        localReceive = new LocalReceive();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("send_LocalBroadcast_zll");

        localBroadcastManager.registerReceiver(localReceive,intentFilter);

        Button button = (Button)findViewById(R.id.button5_4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("send_LocalBroadcast_zll");
                localBroadcastManager.sendBroadcast(intent);
            }
        });



    }

    class LocalReceive extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"收到本地广播",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceive);
    }
}
