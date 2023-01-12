package com.example.yum1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yum1.Adapter.DashboardAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    private ImageButton nearMeBtn, directoryBtn,updatesBtn;
    private TextView greetings;
    private DashboardAdapter popularAdapter,westernAdapter,localAdapter;
    private RecyclerView popularView,westernView, localView;
    //Toolbar
    private NavigationView mainNavView;
    private View mainNavHeader;
    private DrawerLayout mainDrawer;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //Toolbar & Drawer
        mainDrawer = findViewById(R.id.main_drawer);
        toolbar = findViewById(R.id.toolbar);
        mainNavView = findViewById(R.id.main_nav_view);
        mainNavHeader = mainNavView.getHeaderView(0);
        startAnimation();

        setSupportActionBar(toolbar);
        mainNavView.bringToFront();
        mainNavView.setCheckedItem(R.id.location_op);

        mainNavView.setNavigationItemSelectedListener(this);
    }

        public void onBackPressed(){
            Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();
            if (mainDrawer.isDrawerOpen(GravityCompat.START)){
                Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();
                mainDrawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }




        //connect to widget
        nearMeBtn = findViewById(R.id.nearMeBtn);
        directoryBtn = findViewById(R.id.directoryBtn);
        updatesBtn = findViewById(R.id.updatesBtn);
        popularView = findViewById(R.id.popular_view);
        westernView = findViewById(R.id.western_view);
        localView = findViewById(R.id.local_view);
        greetings = findViewById(R.id.dashboard_greeting_tv);

        //Set Username
        greetings.setText("Hi "+Globals.user.getName()+"!");

        //Popular List View
        popularView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false));
        popularAdapter = new DashboardAdapter(this, Globals.restaurants);
        popularView.setAdapter(popularAdapter);

        //Western List View
        ArrayList<Restaurant> westerns = new ArrayList<>();
        for(int i=0; i<Globals.restaurants.size(); i++)
        {
            //Filter
            if(Globals.restaurants.get(i).getCuisine().equals("Western"))
            {
                westerns.add(Globals.restaurants.get(i));
            }
        }
        westernView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false));
        westernAdapter = new DashboardAdapter(this,westerns);
        westernView.setAdapter(westernAdapter);

        //local cuisine
        ArrayList<Restaurant> locals = new ArrayList<>();
        for(int i=0; i<Globals.restaurants.size(); i++)
        {
            //Filter
            if(Globals.restaurants.get(i).getCuisine().equals("Local Cuisine"))
            {
                locals.add(Globals.restaurants.get(i));
            }
        }
        localView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false));
        localAdapter = new DashboardAdapter(this,locals);
        localView.setAdapter(localAdapter);

        //Directory BTN
        directoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Dashboard.this, DirectoryLocation.class);
                Dashboard.this.startActivity(myIntent);
            }
        });

    }

    private void startAnimation() {
        AnimationDrawable mainNavAnimation = (AnimationDrawable) mainNavHeader.getBackground();
        mainNavAnimation.setEnterFadeDuration(1000);
        mainNavAnimation.setExitFadeDuration(3000);
        mainNavAnimation.start();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cuisine_op:
                Intent anIntent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(anIntent);
                mainDrawer.closeDrawers();
                break;
        }
        return true;
    }
}