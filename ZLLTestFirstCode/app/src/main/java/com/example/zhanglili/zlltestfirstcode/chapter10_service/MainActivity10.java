package com.example.zhanglili.zlltestfirstcode.chapter10_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhanglili.zlltestfirstcode.R;

public class MainActivity10 extends AppCompatActivity implements View.OnClickListener {

    private MyService.DownloadBinder binder;
   //TODO 这种写法很奇怪 ServiceConnection这是一个接口
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyService.DownloadBinder)service;
            binder.startDownload();
            binder.getProgress();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Button button1 = (Button)findViewById(R.id.button10_1);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button10_2);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button10_3);
        button3.setOnClickListener(this);

        Button button4 = (Button)findViewById(R.id.button10_4);
        button4.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button10_1:{
                Intent intent = new Intent(this,MyService.class);
                startService(intent);
                break;
            }
            case R.id.button10_2:{
                Intent intent = new Intent(this,MyService.class);
                stopService(intent);
                break;
            }
            case R.id.button10_3:{
                Intent intent = new Intent(this,MyService.class);
                bindService(intent,connection,BIND_AUTO_CREATE);

                break;
            }
            case R.id.button10_4:{
                unbindService(connection);
                break;
            }
        }

    }
}
