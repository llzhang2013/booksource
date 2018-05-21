package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast.BroadcastBestPractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;

public class loginActivity extends BaseActivity {
    private static final String TAG = "loginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText editText1 = (EditText)findViewById(R.id.editText5_1);
        final EditText editText2 = (EditText)findViewById(R.id.editText5_2);
        Button button = (Button)findViewById(R.id.button5_5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText1.getText().toString().equals("admin") &&editText2.getText().toString().equals("111111")){
                    Log.d(TAG, "onClick: ");
                    Intent intent = new Intent(loginActivity.this,ForceOffActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(loginActivity.this,"不对",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
