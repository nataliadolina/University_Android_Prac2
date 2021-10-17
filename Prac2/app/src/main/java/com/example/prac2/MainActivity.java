package com.example.prac2;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    protected TextView textView;
    protected Button plus_button;
    protected Button minus_button;
    protected Button reset_button;
    protected int counter;

    private Sklonyalka sklon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sklon = new Sklonyalka();
        sklon.__init__("раз");
        setContentView(R.layout.activity_main);

        plus_button = findViewById(R.id.plus_button);
        minus_button = findViewById(R.id.minus_button);
        reset_button = findViewById(R.id.reset_button);


        textView = findViewById(R.id.main_textview);
        plus_button.setOnClickListener(this);
        minus_button.setOnClickListener(this);
        reset_button.setOnClickListener(this);
        counter = 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.plus_button){
            counter ++;
        } else if (v.getId() == R.id.minus_button){
            counter --;
        } else {
            counter = 0;
        }

        textView.setText("На кнопку нажали: " + counter + " " + sklon.ModifyEnding(Math.abs(counter)));
    }
}

class Sklonyalka {
    protected String _word;
    protected Map<Integer,String> dictionary;
    public void __init__(String word) {
        _word = word;

        dictionary = new HashMap<Integer,String>();
        dictionary.put(0, "");
        dictionary.put(1, "");
        dictionary.put(2, "а");
        dictionary.put(3, "а");
        dictionary.put(4, "а");
        dictionary.put(5, "");
        dictionary.put(6, "");
        dictionary.put(7, "");
        dictionary.put(8, "");
        dictionary.put(9, "");
    }

    public String ModifyEnding(int num){
        if (num / 10 == 1) {
            return _word;
        }
        return _word + dictionary.get(num%10);
    }

}