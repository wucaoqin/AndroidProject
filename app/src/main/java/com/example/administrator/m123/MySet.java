package com.example.administrator.m123;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;
import android.content.ContentValues;
import android.net.Uri;
import android.database.Cursor;
import android.util.Log;
import android.widget.Button;
import android.os.Environment;
import android.content.Context;

import com.example.administrator.m123.Myhome;
import com.example.administrator.m123.NumberOfCaches;
import com.example.administrator.m123.R;

import tool.APNMatchTools;
import tool.ClearDownload;
import java.util.*;

public class MySet extends AppCompatActivity {
    Switch switchauto,allowDownload;
    Button btn_update;
    ImageButton imgClearDowanload,imgcaches,imgreturnmyhome,img_update,img_cachepath;
    Uri uri = Uri.parse("content://telephony/carriers");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.myset);
        switchauto=(Switch)findViewById(R.id.switchauto);
        switchauto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    openAPN();
                }else{
                    closeAPN();
                }
            }
        });
        allowDownload=(Switch)findViewById(R.id.allowDowanload);
        allowDownload.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MySet.this,"功能尚未实现,等待中...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MySet.this,"功能尚未实现,等待中...",Toast.LENGTH_SHORT).show();
                }
            }
        });

        imgClearDowanload=(ImageButton)findViewById(R.id.imgcleardowanload);
        imgClearDowanload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearDownload.cleanInternalCache(MySet.this);
                Toast.makeText(MySet.this,"已清除缓存",Toast.LENGTH_SHORT).show();
            }
        });
        img_update=(ImageButton)findViewById(R.id.img_update);
        img_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MySet.this,"已是最新版本",Toast.LENGTH_SHORT).show();;
            }
        });
        btn_update=(Button)findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MySet.this,"已是最新版本",Toast.LENGTH_SHORT).show();
            }
        });
        imgcaches=(ImageButton)findViewById(R.id.imgnumberofcaches);
        imgcaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MySet.this,NumberOfCaches.class);
                startActivity(intent);
            }
        });
        imgreturnmyhome=(ImageButton)findViewById(R.id.imgreturnmyhome);
        imgreturnmyhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MySet.this,Myhome.class);
                startActivity(intent);
            }
        });
        img_cachepath=(ImageButton)findViewById(R.id.img_cachepath);
        img_cachepath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sss=MySet.getDiskCachePath(MySet.this);
                Toast.makeText(MySet.this,sss,Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static String getDiskCachePath(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        } else {
            return context.getCacheDir().getPath();
        }
    }
    public  void openAPN(){
        List<APN> list = getAPNList();
        for (APN apn : list) {
            ContentValues cv = new ContentValues();
            cv.put("apn", APNMatchTools.matchAPN(apn.apn));
            cv.put("type", APNMatchTools.matchAPN(apn.type));
            getContentResolver().update(uri, cv, "_id=?", new String[]{apn.id});
        }
    }
    public void closeAPN(){
        List<APN> list = getAPNList();
        for (APN apn : list) {
            ContentValues cv = new ContentValues();
            cv.put("apn", APNMatchTools.matchAPN(apn.apn)+"mdev");
            cv.put("type", APNMatchTools.matchAPN(apn.type)+"mdev");
            getContentResolver().update(uri, cv, "_id=?", new String[]{apn.id});
        }
    }
    private List<APN> getAPNList(){
        String tag = "Main.getAPNList()";
//current不为空表示可以使用的APN
        String  projection[] = {"_id,apn,type,current"};
        Cursor cr = this.getContentResolver().query(uri, projection, null, null, null);
        List<APN> list = new ArrayList<APN>();
        while(cr!=null && cr.moveToNext()){
            Log.d(tag, cr.getString(cr.getColumnIndex("_id")) + "  " + cr.getString(cr.getColumnIndex("apn")) + "  " + cr.getString(cr.getColumnIndex("type"))+ "  " + cr.getString(cr.getColumnIndex("current")));
            APN a = new APN();
            a.id = cr.getString(cr.getColumnIndex("_id"));
            a.apn = cr.getString(cr.getColumnIndex("apn"));
            a.type = cr.getString(cr.getColumnIndex("type"));
            list.add(a);
        }
        if(cr!=null)
            cr.close();
        return list;
    }
    public static class APN{
        String id;
        String apn;
        String type;
    }
}

