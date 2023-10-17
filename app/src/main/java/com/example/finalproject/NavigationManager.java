package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationManager implements NavigationView.OnNavigationItemSelectedListener {

    private Activity activity;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    public NavigationManager(Activity activity, DrawerLayout drawerLayout, NavigationView navigationView) {
        this.activity = activity;
        this.drawerLayout = drawerLayout;
        this.navigationView = navigationView;
        this.navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the home action
            startActivity(new Intent(activity, HomePageActivity.class));
        } else if (id == R.id.nav_profile) {
            // Handle the profile action
            //startActivity(new Intent(activity, ProfileActivity.class));
        } else if (id == R.id.nav_myplans) {
            // Handle the my plans action
            //startActivity(new Intent(activity, MyPlansActivity.class));
        } else if (id == R.id.nav_buynewplan) {
            // Handle the buy new plan action
            //startActivity(new Intent(activity, BuyNewPlanActivity.class));
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void startActivity(Intent intent) {
        activity.startActivity(intent);
    }
}

