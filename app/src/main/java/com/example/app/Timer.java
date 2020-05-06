package com.example.app;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
public class Timer extends AppCompatActivity {
    TextView timerTextView;
    SeekBar timerSeekBar;
    Button startButton;
    boolean counterIsActive = false;
    CountDownTimer countDownTimer;
    public void buttonClicked (View view) {
        counterIsActive = true;
        timerSeekBar.setEnabled(false);
        startButton.setText("STOP");
        if (counterIsActive = false) {
            resetTimer();
        } else {
            countDownTimer= new CountDownTimer(timerSeekBar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    updateTimer((int) (millisUntilFinished / 1000));
                }
                @Override
                public void onFinish() {
                    resetTimer();
                }
            }.start();
        }
    }
    public void updateTimer (int secondsLeft){
        int minutes =  secondsLeft / 60;
        int seconds =  secondsLeft - (minutes * 60);
        String secondString = Integer.toString(seconds);
        if (seconds <=9){
            secondString = "0" + secondString;
        }
        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }
    public  void  resetTimer(){
        timerTextView.setText("0:10");
        timerSeekBar.setProgress(10);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        startButton.setText("Start");
        counterIsActive = false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        startButton = findViewById(R.id.startButton);
        timerSeekBar = findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.timerTextView);
        int max = 600;
        int progress = 10;
        int min = progress / 60;
        int sec = progress - (min * 60);
        timerSeekBar.setMax(max);
        timerSeekBar.setProgress(progress);
        timerTextView.setText(min + ":" + sec);
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
