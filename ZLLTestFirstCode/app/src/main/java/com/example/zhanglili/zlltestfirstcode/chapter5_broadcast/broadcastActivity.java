package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast;

import android.content.BroadcastReceiver;
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

public class broadcastActivity extends AppCompatActivity {
    private static final String TAG = "broadcastActivity";

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(broadcastActivity.this,"发送广播",Toast.LENGTH_LONG).show();
                Intent intent = new Intent("com.example.broadcast_ZLL_BROATCAST");
                sendBroadcast(intent);//发送自定义广播 这个intent 真是万能的
                //???TODO  sendBroadcast是 context的方法 怎么没收到消息 奇怪
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
