package com.example.zhanglili.zlltestfirstcode.chapter3_List;

/**
 * Created by zhanglili on 2018/5/10.
 */

public class Fruit {
    private String name;
    private int imageId;
     public Fruit(String name,int imageId){
         this.name = name;
         this.imageId = imageId;
     }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
