package com.example.bxj214_lab4.Controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

import com.example.bxj214_lab4.Model.Starship;
import com.example.bxj214_lab4.R;
import com.example.bxj214_lab4.StarshipActivity;


public class MainController implements View.OnClickListener{
    private final Activity activity;

    public MainController(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button1){
            launchStarShipActivity("NCC-1701-A");
        }
        else if(view.getId() == R.id.button2){
            launchStarShipActivity("NCC-1701-D");
        }
        else if(view.getId() == R.id.button3){
            launchStarShipActivity("NCC-74656");
        }
    }

    private void launchStarShipActivity(String reg){
        Intent intent = new Intent(activity, StarshipActivity.class);
        intent.putExtra("reg", reg);
        activity.startActivity(intent);
    }

}
