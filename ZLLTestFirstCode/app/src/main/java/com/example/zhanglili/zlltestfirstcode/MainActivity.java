package com.example.zhanglili.zlltestfirstcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.chapter10_service.MainActivity10;
import com.example.zhanglili.zlltestfirstcode.chapter2_intent.FirstActivity;
import com.example.zhanglili.zlltestfirstcode.chapter2_intent.ThirdActivity;
import com.example.zhanglili.zlltestfirstcode.chapter3_List.ListActivity;
import com.example.zhanglili.zlltestfirstcode.chapter3_List.ListRecycle;
import com.example.zhanglili.zlltestfirstcode.chapter5_broadcast.broadcastActivity;
import com.example.zhanglili.zlltestfirstcode.chapter6_ContentProvider.Main6Activity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "zlltestfirstcode";
    private String[] items = {"listView","RecycleView","chapter2","广播","chapter6_运行时权限","chapter10_service"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,items);
//        //对于一个没有导入的类 鼠标放在上面 option_回车 自动导入（我是怎么知道的呢？报红的时候鼠标放上上面一点就有提示）
//        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyleView);
//        recyclerView.setLayoutManager(adapter);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ss = Integer.toString(position)+","+String.valueOf(position);

                Log.d(TAG, "onItemClick: ");

                switch (position){
                    case 0:{

                        Intent intent = new Intent(MainActivity.this, ListActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 1:{
                        Intent intent = new Intent(MainActivity.this, ListRecycle.class);
                        startActivity(intent);
                        break;

                    }
                    case 2:{
                        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        Intent intent = new Intent(MainActivity.this, broadcastActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:{
                        Intent intent = new Intent(MainActivity.this, Main6Activity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        Intent intent = new Intent(MainActivity.this, MainActivity10.class);
                        startActivity(intent);
                        break;
                    }
                }

            }
        });

    }
}
