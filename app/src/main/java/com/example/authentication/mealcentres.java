package com.example.authentication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mealcentres extends AppCompatActivity {

    Uri Locmap,viewList,viewonmap;
    LinearLayout mViewList,mViewmap,mGoogleMaps;

    String vl,vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealcentres);
        mGoogleMaps=findViewById(R.id.view_location);
        mViewList=findViewById(R.id.downloadList);
        mViewmap=findViewById(R.id.mapview);
        Locmap=Uri.parse("https://goo.gl/maps/XuuDBydWziW29hsY6");
        mGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Locmap);
                startActivity(intent);
            }
        });

        viewList=Uri.parse("https://drive.google.com/file/d/1CbINvwzS_pLH4C2ydIos0B-tHVYb-pJU/view?usp=sharing");
        mViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,viewList);
                startActivity(intent);
            }
        });
        viewonmap=Uri.parse("https://drive.google.com/file/d/1FW9VWVzML2jHteVtUMyL-_A21s5leY-N/view?usp=sharing");
        mViewmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,viewonmap);
                startActivity(intent);
            }
        });



    }
}

