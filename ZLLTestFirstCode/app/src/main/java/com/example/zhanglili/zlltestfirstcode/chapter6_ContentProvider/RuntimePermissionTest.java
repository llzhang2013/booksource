package com.example.zhanglili.zlltestfirstcode.chapter6_ContentProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;

public class RuntimePermissionTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission_test);
        Button btn = (Button)findViewById(R.id.button6_4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RuntimePermissionTest.this 为什么不能直接用this???TODO
                if(ContextCompat.checkSelfPermission(RuntimePermissionTest.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(RuntimePermissionTest.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }else{
                    call();
                }



            }
        });
    }

    private void call(){
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);

        }catch (SecurityException e){
            e.printStackTrace();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       switch (requestCode){
           case 1:{
               if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                   call();
               }else{
                   //this这里怎么能用this???TODO
                   Toast.makeText(this,"拒绝了",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           default:
       }

    }
}
