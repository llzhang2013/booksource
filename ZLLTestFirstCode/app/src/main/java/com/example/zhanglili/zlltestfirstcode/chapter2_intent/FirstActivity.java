package com.example.zhanglili.zlltestfirstcode.chapter2_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:{

                Intent intent = new Intent("android.intent.action.APP_ERROR");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("android.intent.category.ZLL");

                startActivity(intent);

                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);

                break;
            }
            case R.id.item2:{
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("data1","1111");

                startActivity(intent);

                break;
            }
            case R.id.item3:{

                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                startActivityForResult(intent,1);
                break;



            }

        }
        return  true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "requestCode=: "+requestCode);
        switch (resultCode){
            case RESULT_OK:{
                String returnData = data.getStringExtra("data2");
                Log.d(TAG, "requestCode=: "+requestCode);

                break;
            }
        }
    }
}
