package com.example.vesakcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class greeting_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting_page);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}