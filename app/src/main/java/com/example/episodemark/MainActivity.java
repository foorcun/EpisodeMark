package com.example.episodemark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button showAllbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAllbtn = findViewById(R.id.show_all_series);
        showAllbtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ShowAllActivity.class));

        });

    }
}