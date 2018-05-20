package com.example.zhanglili.testseflnotify;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
                
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent("111");
                intent.setComponent(new ComponentName("com.example.zhanglili.testseflnotify",
                        "com.example.zhanglili.testseflnotify.MyReceiver"));//这句至关重要啊 啊啊
                sendBroadcast(intent);
            }
        });
    }
}
