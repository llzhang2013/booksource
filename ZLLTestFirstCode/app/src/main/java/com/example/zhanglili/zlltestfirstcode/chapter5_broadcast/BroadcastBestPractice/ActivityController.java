package com.example.zhanglili.zlltestfirstcode.chapter5_broadcast.BroadcastBestPractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglili on 2018/5/21.
 */

public class ActivityController {

    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);

    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);

    }

    public static void finshAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }

    }

}
