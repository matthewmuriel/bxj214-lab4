package com.example.bxj214_lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.bxj214_lab4.Controller.MainController;
/**
 * MainActivity class which shows the activity_main.xml to the user
 * invokes the MainController class to receive, interpret, & update the model class
 *
 * @author Matthew Muriel bxj214
 * UTSA CS 3443 - Lab 4
 * Spring 2023
 */
public class MainActivity extends AppCompatActivity {
    private MainController controller;

    /**
     * onCreate method which instructs the app what to do when the program when is run
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this);

        setupButton(R.id.button1);
        setupButton(R.id.button2);
        setupButton(R.id.button3);
    }
    /**
     * setupButton method which creates the buttons for the program
     */
    private void setupButton(int buttonID){
        Button button = findViewById(buttonID);
        button.setOnClickListener(controller);
    }
}