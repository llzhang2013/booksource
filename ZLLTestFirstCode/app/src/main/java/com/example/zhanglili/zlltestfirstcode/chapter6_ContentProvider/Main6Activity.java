package com.example.zhanglili.zlltestfirstcode.chapter6_ContentProvider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.zhanglili.zlltestfirstcode.R;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Main6Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Button btn1 = (Button)findViewById(R.id.button6_1);
        Button btn2 = (Button)findViewById(R.id.button6_2);
        Button btn3 = (Button)findViewById(R.id.button6_3);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button6_1){
            Log.d(TAG, "onClick: ");
            Intent intent = new Intent(this,RuntimePermissionTest.class);
            startActivity(intent);
        }else if(v.getId()==R.id.button6_2){
            Intent intent = new Intent(this,ReadContact.class);
            startActivity(intent);
        }
        
    }
}
