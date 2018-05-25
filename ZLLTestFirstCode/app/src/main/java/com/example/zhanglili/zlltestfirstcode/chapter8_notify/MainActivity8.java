package com.example.zhanglili.zlltestfirstcode.chapter8_notify;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhanglili.zlltestfirstcode.R;


public class MainActivity8 extends AppCompatActivity implements View.OnClickListener {
    private int notify_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Button button1 = (Button)findViewById(R.id.button8_1);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button8_2);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button8_3);
        button3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button8_1:{

                Intent intent = new Intent(this,NotifyActivity.class);
                intent.putExtra("id",notify_id);
                PendingIntent pi = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_ONE_SHOT);

                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this,"default")
                        .setContentTitle("测试通知")
                        .setContentText("内容")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setWhen(System.currentTimeMillis())
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground))
                        .setContentIntent(pi)
                        //.setAutoCancel(true)
                        .build();
                manager.notify(notify_id++,notification);



                break;
            }
            case R.id.button8_2:{

                break;
            }
            case R.id.button8_3:{


                break;
            }

        }


    }
}
