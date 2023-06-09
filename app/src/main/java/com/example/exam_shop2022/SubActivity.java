package com.example.exam_shop2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        findViewById(R.id.button).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        finish();
    }
}