package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mediaBulliten extends AppCompatActivity {
    TextView mMedia1,mMedia2,mMedia3,mMedia4,mMedia5,mPress1,mPress2,mPress3;
    Uri m1,m2,m3,m4,m5,p1,p2,p3;
    DatabaseReference db,db2;
    FirebaseDatabase fb,fb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_bulliten);
        mMedia1=findViewById(R.id.media1);
        mMedia2=findViewById(R.id.media2);
        mMedia3=findViewById(R.id.media3);
        mMedia4=findViewById(R.id.media4);
        mMedia5=findViewById(R.id.media5);

        mPress1=findViewById(R.id.press1);
        mPress2=findViewById(R.id.press2);
        mPress3=findViewById(R.id.press3);
        Toast.makeText(mediaBulliten.this, "Loading...", Toast.LENGTH_LONG).show();
        fb=FirebaseDatabase.getInstance();
        db=fb.getReference();
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1=dataSnapshot.child("Media").child("recent1").getValue().toString();
                String s2=dataSnapshot.child("Media").child("recent2").getValue().toString();
                String s3=dataSnapshot.child("Media").child("recent3").getValue().toString();
                String s4=dataSnapshot.child("Media").child("recent4").getValue().toString();
                String s5=dataSnapshot.child("Media").child("recent5").getValue().toString();
                String s6=dataSnapshot.child("Press").child("press1").getValue().toString();
                String s7=dataSnapshot.child("Press").child("press2").getValue().toString();
                String s8=dataSnapshot.child("Press").child("press3").getValue().toString();

                mPress1.setText(s6);
                mPress2.setText(s7);
                mPress3.setText(s8);
                mMedia1.setText(s1);
                mMedia2.setText(s2);
                mMedia3.setText(s3);
                mMedia4.setText(s4);
                mMedia5.setText(s5);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        m1=Uri.parse("https://drive.google.com/file/d/1GVgg5WdcjgpmerDNEtgaBiGo9QVMc833/view?usp=sharing");
        mMedia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,m1);
                startActivity(intent);
            }
        });
        m2=Uri.parse("https://drive.google.com/file/d/1T2R3X4pEkswpgHnKFcWuIgDJLdZOWKgj/view?usp=sharing");
        mMedia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,m2);
                startActivity(intent);
            }
        });
        m3=Uri.parse("https://drive.google.com/file/d/1AzSPlEKxjvA_zzv5V9GK5UXMZIjghyW0/view?usp=sharing");
        mMedia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,m3);
                startActivity(intent);
            }
        });
        m4=Uri.parse("https://drive.google.com/file/d/1q30GE9xBGkddonF2IeEJddYJ1Hm4QNqk/view?usp=sharing");
        mMedia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,m4);
                startActivity(intent);
            }
        });
        m5=Uri.parse("https://drive.google.com/file/d/1egyAKmpU7kyQk-RhZDoAh59IgMSlGqKA/view?usp=sharing");
        mMedia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,m5);
                startActivity(intent);
            }
        });
        p1=Uri.parse("https://youtu.be/wYKlqJN1i00");
        mPress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,p1);
                startActivity(intent);
            }
        });
        p2=Uri.parse("https://youtu.be/jFq8R3vs2b8");
        mPress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,p2);
                startActivity(intent);
            }
        });
        p3=Uri.parse("https://youtu.be/OLnUDsT6eeI");
        mPress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,p3);
                startActivity(intent);
            }
        });


    }
}
