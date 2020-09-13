package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GovtOrders extends AppCompatActivity {
    TextView govt1,govt2,govt3,govt4,govt5,moreup;
    Uri g1,g2,g3,g4,g5,mp;
    Button go;
    FirebaseDatabase fb;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govtorders);
        Toast.makeText(GovtOrders.this, "Loading...", Toast.LENGTH_LONG).show();
        govt1=findViewById(R.id.go1);
        govt2=findViewById(R.id.go2);
        govt3=findViewById(R.id.go3);
        govt4=findViewById(R.id.go4);
        govt5=findViewById(R.id.go5);
        go=findViewById(R.id.gobtn);
        moreup=findViewById(R.id.more);
        fb=FirebaseDatabase.getInstance();
        db=fb.getReference().child("Government Orders");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1=dataSnapshot.child("gt1").getValue().toString();
                String s2=dataSnapshot.child("gt2").getValue().toString();
                String s3=dataSnapshot.child("gt3").getValue().toString();
                String s4=dataSnapshot.child("gt4").getValue().toString();
                String s5=dataSnapshot.child("gt5").getValue().toString();
                String s6=dataSnapshot.child("more").getValue().toString();
                govt1.setText(s1);
                govt2.setText(s2);
                govt3.setText(s3);
                govt4.setText(s4);
                govt5.setText(s5);
                moreup.setText(s6);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        g1=Uri.parse("https://drive.google.com/file/d/18hST9ycXhZSCPBrRxM2d5ZgHBtywO7gm/view?usp=sharing");
        govt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,g1);
                startActivity(i);
            }
        });
        g2=Uri.parse("https://drive.google.com/file/d/1Q5iLRWXXwIO1bN6NtMqbauCM0k0ggdTh/view?usp=sharing");
        govt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,g2);
                startActivity(i);
            }
        });
        g3=Uri.parse("https://drive.google.com/file/d/1XHO3M3tzNAZ182g-M8M_jZdcdLfCWx0r/view?usp=sharing");
        govt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,g3);
                startActivity(i);
            }
        });
        g4=Uri.parse("https://drive.google.com/file/d/1MxxqInoZQLEU_-r1OlNhBUcWHlDuawio/view?usp=sharing");
        govt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,g4);
                startActivity(i);
            }
        });
        g5=Uri.parse("https://drive.google.com/file/d/1SvaBLDjOEBTsGfL0b-FKfo-mRx8ptjAE/view?usp=sharing");
        govt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,g5);
                startActivity(i);
            }
        });
        mp=Uri.parse("https://covid19.telangana.gov.in/government-orders/");
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,mp);
                startActivity(i);
            }
        });


    }
}
