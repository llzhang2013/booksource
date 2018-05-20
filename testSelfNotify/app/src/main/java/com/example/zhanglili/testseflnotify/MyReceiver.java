package com.example.zhanglili.testseflnotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{
//public class MyReceiver extends BroadcastReceiver {
//    private static final String TAG = "MyReceiver1111";
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        Log.d(TAG, "onReceive: ");
//        Toast.makeText(context,"收到消息",Toast.LENGTH_SHORT).show();
//    }
private static final String TAG = "testseflnotify";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:zll ");
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
        // abortBroadcast();
    }
}
