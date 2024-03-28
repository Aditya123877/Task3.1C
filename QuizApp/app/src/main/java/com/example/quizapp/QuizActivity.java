package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView welcomeTextView, questionTextView, scoreTextView;
    private Button option1Button, option2Button, option3Button, nextButton;
    private ProgressBar progressBar;

    private String[] questions = {"Which is the largest island in the world?",
            "Which is the most populated city in the world?",
            "Which of these Middle-Eastern countries does not have a desert?"};

    private String[][] options = {{"Australia", "Greenland", "Borneo"},
            {"Tokyo", "Beijing", "Delhi"},
            {"Iran", "Saudi Arabia", "Lebanon"}};

    private int[] answers = {2, 1, 3}; // 1 for option1Button, 2 for option2Button, 3 for option3Button
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        questionTextView = findViewById(R.id.questionTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        nextButton = findViewById(R.id.nextButton);
        progressBar = findViewById(R.id.progressBar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("USER_NAME");
        welcomeTextView.setText("Welcome, " + name + "!");

        updateQuestion();

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion < questions.length - 1) {
                    currentQuestion++;
                    updateQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, CompletionActivity.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void updateQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        option1Button.setText(options[currentQuestion][0]);
        option2Button.setText(options[currentQuestion][1]);
        option3Button.setText(options[currentQuestion][2]);
        scoreTextView.setText("Score: " + score + "/" + (currentQuestion + 1));
        progressBar.setProgress((currentQuestion + 1) * 100 / questions.length);
        option1Button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        option2Button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        option3Button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        nextButton.setEnabled(false);
    }

    private void checkAnswer(int selectedOption) {
        if (selectedOption == answers[currentQuestion]) {
            score++;
        }

        switch (answers[currentQuestion]) {
            case 1:
                option1Button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                break;
            case 2:
                option2Button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                break;
            case 3:
                option3Button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                break;
        }

        if (selectedOption != answers[currentQuestion]) {
            switch (selectedOption) {
                case 1:
                    option1Button.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                    break;
                case 2:
                    option2Button.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                    break;
                case 3:
                    option3Button.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                    break;
            }
        }

        nextButton.setEnabled(true);
    }
}
