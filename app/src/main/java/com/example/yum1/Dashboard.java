package com.example.yum1;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yum1.Adapter.DashboardAdapter;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    //variables
    private ImageButton nearMeBtn, directoryBtn,updatesBtn;
    private TextView greetings;
    private DashboardAdapter popularAdapter,westernAdapter;
    private RecyclerView popularView,westernView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Log.d(TAG, "Restaurants list count 3: " + Globals.restaurants.size());


        //connect to widget
        nearMeBtn = findViewById(R.id.nearMeBtn);
        directoryBtn = findViewById(R.id.directoryBtn);
        updatesBtn = findViewById(R.id.updatesBtn);
        popularView = findViewById(R.id.popular_view);
        westernView = findViewById(R.id.western_view);
        greetings = findViewById(R.id.dashboard_greeting_tv);

        //Set Username
        greetings.setText("Hi "+Globals.user.getName()+"!");

        //Popular List View
        popularView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false));
        popularAdapter = new DashboardAdapter(this, Globals.restaurants);
        popularView.setAdapter(popularAdapter);

//        //Western List View
//        ArrayList<Restaurant> westerns = new ArrayList<>();
//        for(int i=0; i<Globals.restaurants.size(); i++)
//        {
//            //Filter
//            if(Globals.restaurants.get(i).getCuisines().equals("western"))
//            {
//                westerns.add(Globals.restaurants.get(i));
//            }
//        }
//        westernView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false));
//        westernAdapter = new DashboardAdapter(this,westerns);
//        westernView.setAdapter(westernAdapter);

        //local cuisine
 //       ArrayList<Restaurant> locals = new ArrayList<>();
//        for(int i=0; i<Globals.restaurants.size(); i++)
//        {
//            //Filter
//            if(Globals.restaurants.get(i).getCuisines().equals("local"))
//            {
//                local.add(Globals.restaurants.get(i));
//            }
//        }
//        localView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false));
//        localAdapter = new DashboardAdapter(this,locals);
//        localView.setAdapter(localAdapter);

    }
}