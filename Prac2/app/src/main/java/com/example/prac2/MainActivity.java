package com.example.prac2;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    protected TextView textView;
    protected Button button;
    protected int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.main_button);
        textView = findViewById(R.id.main_textview);
        button.setOnClickListener(this);
        counter = 0;

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        counter ++;
        textView.setText("На кнопку нажали: " + counter + " раз");
    }
}