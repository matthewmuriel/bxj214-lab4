package com.example.bxj214_lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.bxj214_lab4.Controller.MainController;

public class MainActivity extends AppCompatActivity {
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this);

        setupButton(R.id.button1);
        setupButton(R.id.button2);
        setupButton(R.id.button3);
    }

    private void setupButton(int buttonID){
        Button button = findViewById(buttonID);
        button.setOnClickListener(controller);
    }
}