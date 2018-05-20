package com.example.zhanglili.zlltestfirstcode.chapter6_ContentProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhanglili.zlltestfirstcode.R;

import java.util.ArrayList;
import java.util.List;

public class ReadContact extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private List<String> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contact);
        ListView listView = (ListView)findViewById(R.id.listView6);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactList);
        listView.setAdapter(adapter);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }else{
            readContacts();
        }

    }

    private void readContacts(){
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,null,null,null);
            if(cursor!=null){
                while (cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contactList.add(name+"\n"+number);
                }
            }
            adapter.notifyDataSetChanged();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            readContacts();
        }else{
            Toast.makeText(this,"拒绝读取",Toast.LENGTH_SHORT).show();
        }

    }
}
