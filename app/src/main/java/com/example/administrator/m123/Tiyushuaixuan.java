package com.example.administrator.m123;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import tool.QueryVedDetailThred;
import tool.QueryVedThred;

public class Tiyushuaixuan extends Activity {
    ImageView bttnp1,bttnp2,bttnp3,bttnp4;
    TextView mTextView,screenTextViewp1,screenTextViewp2,screenTextViewp3,screenTextViewp4;
    Button btnp1,btnp2,btnp3,btnp4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiyushuaixuan);

        bttnp1 = (ImageView) findViewById(R.id.moviep1);
        bttnp2 = (ImageView) findViewById(R.id.moviep2);
        bttnp3 = (ImageView) findViewById(R.id.moviep3);
        bttnp4 = (ImageView) findViewById(R.id.moviep4);
        screenTextViewp1 = (TextView) findViewById(R.id.screenmoviep1);
        screenTextViewp2 = (TextView) findViewById(R.id.screenmoviep2);
        screenTextViewp3 = (TextView) findViewById(R.id.screenmoviep3);
        screenTextViewp4 = (TextView) findViewById(R.id.screenmoviep4);
        btnp1 = (Button) findViewById(R.id.screenp1);
        btnp2 = (Button) findViewById(R.id.screenp2);
        btnp3 = (Button) findViewById(R.id.screenp3);
        btnp4 = (Button) findViewById(R.id.screenp4);

        btnp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryVedThred send =new QueryVedThred("","体育","",btnp1.getText().toString().trim());
                Thread thread = new Thread(send);
                thread.start();
                try {
                    thread.join();
                    if(QueryVedThred.result !=0){
                        QueryVedDetailThred send1 =new QueryVedDetailThred(QueryVedThred.list);
                        Thread thread1 =new Thread(send1);
                        thread1.start();
                        thread1.join();
                        clear();
                        Glide.with(Tiyushuaixuan.this).load(QueryVedDetailThred.map.get(0).get(3)).into(bttnp1);
                        screenTextViewp1.setText(QueryVedDetailThred.map.get(0).get(0));
                    }else{
                        Toast.makeText(Tiyushuaixuan.this,"查询结果为空",Toast.LENGTH_SHORT).show();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
        btnp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryVedThred send =new QueryVedThred("","体育","",btnp2.getText().toString().trim());
                Thread thread = new Thread(send);
                thread.start();
                try {
                    thread.join();
                    if(QueryVedThred.result !=0){
                        QueryVedDetailThred send1 =new QueryVedDetailThred(QueryVedThred.list);
                        Thread thread1 =new Thread(send1);
                        thread1.start();
                        thread1.join();
                        clear();
                        Glide.with(Tiyushuaixuan.this).load(QueryVedDetailThred.map.get(0).get(3)).into(bttnp1);
                        screenTextViewp1.setText(QueryVedDetailThred.map.get(0).get(0));
                    }else{
                        Toast.makeText(Tiyushuaixuan.this,"查询结果为空",Toast.LENGTH_SHORT).show();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        btnp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryVedThred send =new QueryVedThred("","体育","",btnp3.getText().toString().trim());
                Thread thread = new Thread(send);
                thread.start();
                try {
                    thread.join();
                    if(QueryVedThred.result !=0){
                        QueryVedDetailThred send1 =new QueryVedDetailThred(QueryVedThred.list);
                        Thread thread1 =new Thread(send1);
                        thread1.start();
                        thread1.join();
                        clear();
                        Glide.with(Tiyushuaixuan.this).load(QueryVedDetailThred.map.get(0).get(3)).into(bttnp1);
                        screenTextViewp1.setText(QueryVedDetailThred.map.get(0).get(0));
                    }else{
                        Toast.makeText(Tiyushuaixuan.this,"查询结果为空",Toast.LENGTH_SHORT).show();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        btnp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryVedThred send =new QueryVedThred("","体育","",btnp4.getText().toString().trim());
                Thread thread = new Thread(send);
                thread.start();
                try {
                    thread.join();
                    if(QueryVedThred.result !=0){
                        QueryVedDetailThred send1 =new QueryVedDetailThred(QueryVedThred.list);
                        Thread thread1 =new Thread(send1);
                        thread1.start();
                        thread1.join();
                        clear();
                        Glide.with(Tiyushuaixuan.this).load(QueryVedDetailThred.map.get(0).get(3)).into(bttnp1);
                        screenTextViewp1.setText(QueryVedDetailThred.map.get(0).get(0));
                    }else{
                        Toast.makeText(Tiyushuaixuan.this,"查询结果为空",Toast.LENGTH_SHORT).show();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        bttnp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(screenTextViewp1);
            }
        });
        bttnp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(screenTextViewp2);
            }
        });
        bttnp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s10(screenTextViewp3);
            }
        });
    }

    private void clear(){
        screenTextViewp1.setText("");
        screenTextViewp2.setText("");
        screenTextViewp3.setText("");
        screenTextViewp4.setText("");
        bttnp1.setImageDrawable(null);
        bttnp2.setImageDrawable(null);
        bttnp3.setImageDrawable(null);
        bttnp4.setImageDrawable(null);
    }

    private void s10(TextView text) {
        Thread thread = new Thread(new QueryVedThred(text.getText().toString().trim(),"","",""));
        thread.start();
        try {
            thread.join();
            if (QueryVedThred.result != 0) {
                Intent intent = new Intent(Tiyushuaixuan.this, Play.class);
                intent.putExtra("showdata", QueryVedThred.list.get(0)+"");
                startActivity(intent);
            } else {
                Toast.makeText(Tiyushuaixuan.this, "传递的数值为空!", Toast.LENGTH_SHORT).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
