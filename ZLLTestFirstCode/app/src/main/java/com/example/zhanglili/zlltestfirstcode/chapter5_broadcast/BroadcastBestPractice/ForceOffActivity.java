package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast.BroadcastBestPractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhanglili.zlltestfirstcode.R;

public class ForceOffActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_off);
        Button button = (Button)findViewById(R.id.button5_6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.zhanglili.zlltestfirstcode.forceOffline");
                sendBroadcast(intent);
            }
        });

    }
}
