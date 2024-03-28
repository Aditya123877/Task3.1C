package com.example.quizapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompletionActivity extends AppCompatActivity {
    private TextView completionMessageTextView, finalScoreTextView;
    private Button restartButton, exitButton;
    private String userName; // Declare userName variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completion);

        completionMessageTextView = findViewById(R.id.completionMessageTextView);
        finalScoreTextView = findViewById(R.id.finalScoreTextView);
        restartButton = findViewById(R.id.restartButton);
        exitButton = findViewById(R.id.exitButton);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);

        completionMessageTextView.setText("Quiz Completed!");
        finalScoreTextView.setText("Score: " + score + "/3");

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
                System.exit(0); // Exit the app
            }
        });
    }
}

