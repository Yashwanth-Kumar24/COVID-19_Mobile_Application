package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_info);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_info:
                break;
            case R.id.nav_cases:

                Intent intent = new Intent(MainActivity.this, cases.class);
                startActivity(intent);
                break;
            case R.id.nav_containment:

                Intent intent13 = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent13);
                break;
            case R.id.signout:

                FirebaseAuth.getInstance().signOut();
                Intent intent14 = new Intent(MainActivity.this, Login.class);
                //intent14.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent14.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent14.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent14);
                break;

            case R.id.nav_media:

                Intent intent9 = new Intent(MainActivity.this, mediaBulliten.class);
                startActivity(intent9);
                break;

            case R.id.nav_govt:

                Intent intent11 = new Intent(MainActivity.this, GovtOrders.class);
                startActivity(intent11);
                break;
            case R.id.nav_alerts:

                Intent intent4 = new Intent(MainActivity.this, alerts.class);
                startActivity(intent4);
                break;
            case R.id.nav_facilities:

                Intent intent7 = new Intent(MainActivity.this, healthfacilities.class);
                startActivity(intent7);
                break;
            case R.id.nav_statewise:

                Intent intent8 = new Intent(MainActivity.this, helpline.class);
                startActivity(intent8);
                break;


            case R.id.nav_emergency:

                Intent intent6 = new Intent(MainActivity.this, controlroom.class);
                startActivity(intent6);
                break;

            case R.id.nav_meal:

                Intent intent5 = new Intent(MainActivity.this, mealcentres.class);
                startActivity(intent5);
                break;


            case R.id.nav_wtsap:

                Intent intent3 = new Intent(MainActivity.this, chatbot.class);
                startActivity(intent3);
                break;

            case R.id.nav_pay:

                Intent intent2 = new Intent(MainActivity.this, DonateCMRF.class);
                startActivity(intent2);
                break;
            case R.id.nav_aarogya:

                Uri feed = Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu");
                Intent intent12 = new Intent(Intent.ACTION_VIEW, feed);
                startActivity(intent12);
                break;

            case R.id.nav_feedback:

                Intent intent10 = new Intent(MainActivity.this, Feedback.class);
                startActivity(intent10);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}


