package com.example.administrator.m123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import tool.QueryVedThred;

public class tiyuzhujiemian extends AppCompatActivity{
    ImageButton btnn1,btnn2,btnn3,btnn4,btnn5,btnn6,btnn7,btnn8,btnn9,btnn10;
    Button btn11;//先声明哦
    TextView textfczlm,textgtxone,textgtxtwo,textxchh;
    static String str;
    String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.tiyuzhuye);
        btnn1 = (ImageButton) findViewById(R.id.imagefczlmp);
        btnn2 = (ImageButton) findViewById(R.id.imagegtxonep);
        btnn3 = (ImageButton) findViewById(R.id.imagegtxtwop);
        btnn4 = (ImageButton) findViewById(R.id.imagexchhp);
        btnn5 = (ImageButton) findViewById(R.id.videop5);
        btnn6 = (ImageButton) findViewById(R.id.videop6);
        btnn7 = (ImageButton) findViewById(R.id.videop7);
        btnn8 = (ImageButton) findViewById(R.id.videop8);
        btnn9 = (ImageButton) findViewById(R.id.videop9);
        btnn10 = (ImageButton) findViewById(R.id.videop10);
        btn11 = (Button) findViewById(R.id.shaixuan);

        textfczlm=(TextView)findViewById(R.id.textfczlmp);
        //为button绑定事件
        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(textfczlm);
            }
        });

        textgtxone=(TextView)findViewById(R.id.textgtxonep);
        //为button绑定事件
        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(textgtxone);
            }
        });
        textgtxtwo=(TextView)findViewById(R.id.textgtxtwop);
        //为button绑定事件
        btnn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(textgtxtwo);
            }
        });
        textxchh=(TextView)findViewById(R.id.textxchhp);
        //为button绑定事件
        btnn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(textxchh);
            }
        });
        btnn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Play.class);
                startActivity(intent);
            }
        });
        btnn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Play.class);
                startActivity(intent);
            }
        });
        btnn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Play.class);

                startActivity(intent);
            }
        });
        btnn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Play.class);
                startActivity(intent);
            }
        });
        btnn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Play.class);
                startActivity(intent);
            }
        });
        btnn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Play.class);
                startActivity(intent);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tiyuzhujiemian.this, Tiyushuaixuan.class);
                startActivity(intent);
            }
        });
    }
    private void s10(TextView text) {
        Thread thread=new Thread(new QueryVedThred(text.getText().toString().trim(),"","",""));
        thread.start();
        try {
            thread.join();
            if (QueryVedThred.result != 0) {
                Intent intent = new Intent(tiyuzhujiemian.this, Play.class);
                intent.putExtra("showdata", QueryVedThred.list.get(0)+"");
                startActivity(intent);
            } else {
                Toast.makeText(tiyuzhujiemian.this, "传递的数值为空!", Toast.LENGTH_SHORT).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
