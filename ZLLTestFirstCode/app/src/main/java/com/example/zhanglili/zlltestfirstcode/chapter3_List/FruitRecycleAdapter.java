package com.example.zhanglili.zlltestfirstcode.chapter3_List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanglili.zlltestfirstcode.R;

import java.util.List;

/**
 * Created by zhanglili on 2018/5/13.
 */
//???<FruitRecycleAdapter.ViewHolder>
public class FruitRecycleAdapter extends RecyclerView.Adapter<FruitRecycleAdapter.ViewHolder>{
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            textView = (TextView)view.findViewById(R.id.textView);
        }

    }

    public FruitRecycleAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getName());


    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
