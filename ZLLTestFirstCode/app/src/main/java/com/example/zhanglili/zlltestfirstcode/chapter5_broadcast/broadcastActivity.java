package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;
import com.example.zhanglili.zlltestfirstcode.chapter5_broadcast.BroadcastBestPractice.loginActivity;

public class broadcastActivity extends AppCompatActivity {
    private static final String TAG = "broadcastActivity";

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);

        Button button = (Button)findViewById(R.id.button5_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 发送自定义广播");

                Intent intent = new Intent("123");
                intent.setComponent(new ComponentName("com.example.zhanglili.zlltestfirstcode","com.example.zhanglili.zlltestfirstcode.chapter5_broadcast.MyReceiver"));
                sendBroadcast(intent);//发送自定义广播 这个intent 真是万能的

            }
        });


        Button button2 = (Button)findViewById(R.id.button5_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //这里不能直接用this
                Intent intent = new Intent(broadcastActivity.this,LocalBroadcast.class);
              startActivity(intent);

            }
        });

        Button button3 = (Button)findViewById(R.id.button5_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里不能直接用this
                Intent intent = new Intent(broadcastActivity.this,loginActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        Log.d(TAG, "onDestroy: ");
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isAvailable()){
                Toast.makeText(broadcastActivity.this,"网络可以用",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(broadcastActivity.this,"网络用不了",Toast.LENGTH_LONG).show();
            }

        }
    }
}
