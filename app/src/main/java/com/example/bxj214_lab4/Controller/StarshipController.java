package com.example.bxj214_lab4.Controller;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bxj214_lab4.Model.Starship;
import com.example.bxj214_lab4.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class StarshipController {
    private final Activity activity;
    private Fleet fleet;

    public StarshipController(Activity activity){
        this.activity = activity;
        this.fleet = new Fleet();
    }

    public void initialize(){
        fleet.loadStarship(activity.getAssets());

        update(activity.getIntent().getStringExtra("reg"));
    }

    public void update(String reg){
        ArrayList<String> crewList = new ArrayList<String>();
        String[] tokens;
        int counter = 0;
        crewList.addAll(fleet.crewlist(reg));

        TextView registration = (TextView) activity.findViewById(R.id.registration);
        TextView starship = (TextView) activity.findViewById(R.id.starshipName);

        starship.setText(fleet.getShipData(reg));
        registration.setText(reg);

        for (String c:crewList){
            tokens = c.split(",");
            TextView name = (TextView) activity.findViewById(activity.getResources().getIdentifier("crewName"+counter,"id", activity.getPackageName()));
            TextView rank = (TextView) activity.findViewById(activity.getResources().getIdentifier("crewRank"+counter,"id", activity.getPackageName()));
            ImageView profile = (ImageView) activity.findViewById(activity.getResources().getIdentifier("crewpic"+counter,"id", activity.getPackageName()));
            name.setText(tokens[0]);
            rank.setText(tokens[1]);

            tokens[0] = tokens[0].toLowerCase();
            tokens = tokens[0].split(" ");

            profile.setImageResource(activity.getResources().getIdentifier(tokens[tokens.length-1],"drawable",activity.getPackageName()));

            counter++;
        }

    }
}

