package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:收到自己发的广播 ");
        Toast.makeText(context,"收到自己发的广播",Toast.LENGTH_LONG).show();
    }
}
