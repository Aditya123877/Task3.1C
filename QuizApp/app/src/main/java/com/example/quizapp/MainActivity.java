package com.example.quizapp;

import android.os.Bundle;

import android.content.Intent;


import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    public Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("USER_NAME", name);
            startActivity(intent);
        });
    }
}
