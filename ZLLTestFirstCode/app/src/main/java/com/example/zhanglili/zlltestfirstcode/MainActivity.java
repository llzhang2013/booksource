package com.example.zhanglili.zlltestfirstcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "zlltestfirstcode";
    private String[] items = {"listView","RecycleView","广播"};

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
                Toast.makeText(MainActivity.this,ss,Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onItemClick: ");
            }
        });

    }
}
