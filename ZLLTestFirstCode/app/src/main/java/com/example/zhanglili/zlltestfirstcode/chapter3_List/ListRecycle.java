package com.example.zhanglili.zlltestfirstcode.chapter3_List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;

import java.util.ArrayList;
import java.util.List;

public class ListRecycle extends AppCompatActivity {


    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_list);
        initFruitList();
        FruitRecycleAdapter adapter = new FruitRecycleAdapter(fruitList);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleId);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        //???TODO 点击事件不管用
         recyclerView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(ListRecycle.this,"jjj",Toast.LENGTH_LONG);
             }
         });

    }

   private void initFruitList(){
        for(int i=0;i<20;i++){
            Fruit fruit = new Fruit("vvv",R.drawable.ic_launcher_foreground);
            fruitList.add(fruit);
            Fruit fruit1 = new Fruit("mmmm",R.drawable.ic_launcher_foreground);
            fruitList.add(fruit1);

        }

    }
}
