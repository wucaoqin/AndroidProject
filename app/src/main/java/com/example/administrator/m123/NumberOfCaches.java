package com.example.administrator.m123;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.m123.R;

public class NumberOfCaches extends AppCompatActivity {
    ImageButton imgreturnmyset;
    RadioButton radioButton1,radioButton2,radioButton3;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.numberofcaches);
        imgreturnmyset=(ImageButton)findViewById(R.id.imgreturnmyset);
        imgreturnmyset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NumberOfCaches.this,MySet.class);
                startActivity(intent);
            }
        });
        //缓存个数功能
        radioButton1=(RadioButton)findViewById(R.id.radiobutton1);
        radioButton2=(RadioButton)findViewById(R.id.radiobutton2);
        radioButton3=(RadioButton)findViewById(R.id.radiobutton3);
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton_checked= (RadioButton) group.findViewById(checkedId);
                String gender=radioButton_checked.getText().toString();
                Toast.makeText(NumberOfCaches.this,gender,Toast.LENGTH_SHORT).show();
                switch (checkedId){
                    case R.id.radiobutton1:
                        //当用户点击1按钮时执行的代码
                        System.out.println(1);
                        break;
                    case R.id.radiobutton2:
                        //当用户点击2按钮时执行的代码
                        System.out.println(2);
                        break;
                    case R.id.radiobutton3:
                        //当用户点击3按钮时执行的代码
                        System.out.println(3);
                        break;
                }
            }
        });
    }
}
