package com.example.bxj214_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bxj214_lab4.Controller.StarshipController;

public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        StarshipController controller = new StarshipController(this);
        controller.initialize();
    }
}