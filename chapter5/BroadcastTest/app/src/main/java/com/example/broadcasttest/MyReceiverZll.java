package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiverZll extends BroadcastReceiver {
    private static final String TAG = "MyReceiverZll";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:zll ");
        Toast.makeText(context, "zll received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
    }
}
