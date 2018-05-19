package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"收到开机启动消息",Toast.LENGTH_LONG).show();
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
