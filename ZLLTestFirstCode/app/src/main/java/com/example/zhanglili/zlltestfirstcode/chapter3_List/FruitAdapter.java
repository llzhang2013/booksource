package com.example.zhanglili.zlltestfirstcode.chapter3_List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanglili.zlltestfirstcode.R;

import java.util.List;

/**
 * Created by zhanglili on 2018/5/10.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int resoureId;

    public FruitAdapter(Context content, int textViewResourceId, List<Fruit> objects){
        super(content,textViewResourceId,objects);
        resoureId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView!=null){
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }else{
            view = LayoutInflater.from(getContext()).inflate(resoureId,parent,false);
            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView = (TextView)view.findViewById(R.id.textView);
            viewHolder = new ViewHolder();
            viewHolder.imageView = imageView;
            viewHolder.textView = textView;
            view.setTag(viewHolder);
        }


        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
       return view;

    }

    class  ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
