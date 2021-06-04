package com.example.hospanic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hospanic.R;

public class Panic extends AppCompatActivity {
    private ImageView btn_back;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);
        btn_back = findViewById(R.id.btn_back_panic);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Panic.super.onBackPressed();
            }
        });

        btn_submit = findViewById(R.id.btn_submit_panic);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Panic.super.onBackPressed();
            }
        });
    }
}