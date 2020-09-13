package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class alerts extends AppCompatActivity {
    DatabaseReference db;
    FirebaseDatabase fb;
    TextView hdng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        final TextView textView2 = (TextView)findViewById( R.id.text32 );
        final TextView textView3 = (TextView)findViewById( R.id.text33 );
        final TextView textView4 = (TextView)findViewById( R.id.text34 );
        final TextView textView5 = (TextView)findViewById( R.id.text35 );
        final TextView textView6 = (TextView)findViewById( R.id.text36 );
        final TextView textView7 = (TextView)findViewById( R.id.text37 );
        hdng= findViewById(R.id.textView14);
        fb=FirebaseDatabase.getInstance();
        db=fb.getReference();
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1=dataSnapshot.child("Alerts").child("1").getValue().toString();
                String s2=dataSnapshot.child("Alerts").child("2").getValue().toString();
                String s3=dataSnapshot.child("Alerts").child("3").getValue().toString();
                String s4=dataSnapshot.child("Alerts").child("4").getValue().toString();
                String s5=dataSnapshot.child("Alerts").child("5").getValue().toString();
                String s6=dataSnapshot.child("Alerts").child("6").getValue().toString();
                textView2.setText(s1);
                textView3.setText(s2);
                textView4.setText(s3);
                textView5.setText(s4);
                textView6.setText(s5);
                textView7.setText(s6);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms

                    }
                }, 5000);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        textView2.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.translate));


        textView3.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.translate));


        textView4.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.translate));


        textView5.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.translate));


        textView6.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.translate));


        textView7.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.translate));


    }
}
