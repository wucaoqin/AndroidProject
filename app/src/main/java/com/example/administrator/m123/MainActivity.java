package com.example.administrator.m123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import tool.SendGet;

import static tool.StringDeal.StringDeal;

public class MainActivity extends AppCompatActivity{
    private Button cartoon;
    Button variety;
    ImageButton myhome,download,homepage,vip;
    TextView txt;
    Button Movie,Tiyu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        cartoon=(Button)findViewById(R.id.cartoon);
        cartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CartoonActive.class);
                startActivity(intent);
            }
        });
        variety=(Button)findViewById(R.id.variety);
        variety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ZongyiShouye.class);
                startActivity(intent);
            }
        });
        homepage=(ImageButton)findViewById(R.id.homepage2);
        vip=(ImageButton)findViewById(R.id.vip);
        download=(ImageButton)findViewById(R.id.download);
        myhome=(ImageButton)findViewById(R.id.myhome);
        Movie=(Button)findViewById(R.id.movie);
        Tiyu=(Button)findViewById(R.id.sports);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Myhome.class);
                startActivity(intent);
            }
        });
        vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Myhome.class);
                startActivity(intent);
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Myhome.class);
                startActivity(intent);
            }
        });
        myhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Myhome.class);
                startActivity(intent);
            }
        });
        Movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Movie.class);
                startActivity(intent);
            }
        });
        Tiyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,tiyuzhujiemian.class);
                startActivity(intent);
            }
        });
    }
    private void send(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = SendGet.SendGet("/QueryServlet/vedio01", "vid=1");
                    txt.setText(s);
                    String[] ss = StringDeal(s);
                    for(int i = 0;i < ss.length;i++){
                        System.out.println(ss[i]);
                        txt.append(ss[i]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
