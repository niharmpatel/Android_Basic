package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class BrainTrainer extends AppCompatActivity {

    Button startButton;
    TextView sumTextView;
    ArrayList<Integer   > answers = new ArrayList<Integer>();
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button playAgainButton;
    TextView resultTextView;
    TextView scoreTextView;
    TextView timerTextView;
    int arrayIndex;
    int score = 0;
    int numOfQuestion = 0;
    CountDownTimer countDownTimer;

    public void  chooseAnswer (View view){
        if( Integer.toString(arrayIndex).equals(view.getTag().toString())){
            resultTextView.setText("Correct answer");
            score++;
        } else {
            resultTextView.setText("Wrong answer");
        }
        numOfQuestion++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numOfQuestion));
        newQuestion();
    }
    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    public void newQuestion (){
        Random random = new Random();
        int a = random.nextInt(25);
        int b = random.nextInt(25);
        sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));
        arrayIndex =  random.nextInt(4);
        answers.clear();
        for (int i = 0; i < 4; i++){
            if (i == arrayIndex) {
                answers.add(a + b);
            } else {
                int wrongAnswers = random.nextInt(50);
                while (wrongAnswers == a + b){
                    wrongAnswers = random.nextInt(50);
                }
                answers.add(wrongAnswers);
            }
        }
        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));
    }

    public void  playAgain (View view){
        score = 0;
        numOfQuestion = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numOfQuestion));
        newQuestion();
        playAgainButton.setVisibility(View.INVISIBLE);
        countDownTimer = new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000 + "s"));
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                resultTextView.setText("Done");
            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_trainer);
        startButton = findViewById(R.id.startButton);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgain);

        playAgain(findViewById(R.id.timerTextView));


    }
}
