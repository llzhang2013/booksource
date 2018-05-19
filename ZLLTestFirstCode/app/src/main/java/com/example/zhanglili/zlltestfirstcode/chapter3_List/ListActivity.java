package com.example.zhanglili.zlltestfirstcode.chapter3_List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.MainActivity;
import com.example.zhanglili.zlltestfirstcode.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private String[] data = {"香蕉","苹果","大鸭梨"};
    private List<Fruit> fruitList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initFruitList();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (ListActivity.this,android.R.layout.simple_list_item_1,data);
        FruitAdapter fruitAdapter = new FruitAdapter(ListActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView)findViewById(R.id.list1);
        listView.setAdapter(fruitAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListActivity.this,fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initFruitList(){
        for(int i=0;i<3;i++){
            Fruit fruit = new Fruit("fff",R.drawable.ic_launcher_background);
            fruitList.add(fruit);
            Fruit fruit1 = new Fruit("fff1",R.drawable.ic_launcher_foreground);
            fruitList.add(fruit1);
        }
    }
}
