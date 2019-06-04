package com.example.administrator.m123;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Play extends Activity {
    TextView mTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        mTextView=(TextView)findViewById(R.id.textView1789456);
        Intent intent = getIntent();
        String showdata = intent.getStringExtra("showdata");
        mTextView.setText(showdata);

    }

}