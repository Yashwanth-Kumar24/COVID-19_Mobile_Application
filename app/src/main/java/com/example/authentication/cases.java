package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Element;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.List;

import javax.xml.transform.Source;

public class cases extends AppCompatActivity {
    DatabaseReference db;
    TextView ac1,ac2,inac1,inac2,dt1,dt2,updt,ac3,inac3,dt3,ac4,inac4,dt4,tot1,tot3;
    LinearLayout list;
    Uri total;
    FirebaseDatabase fdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases);
        ac1=findViewById(R.id.active);
        ac2=findViewById(R.id.active2);
        ac3=findViewById(R.id.active3);
        ac4=findViewById(R.id.active4);
        inac1=findViewById(R.id.inactive);
        inac2=findViewById(R.id.inactive2);
        inac3=findViewById(R.id.inactive3);
        inac4=findViewById(R.id.inactive4);
        dt1=findViewById(R.id.deaths);
        dt2=findViewById(R.id.deaths2);
        dt3=findViewById(R.id.deaths3);
        dt4=findViewById(R.id.deaths4);
        tot1=findViewById(R.id.total1);

        tot3=findViewById(R.id.total3);


        list=findViewById(R.id.listofstatesBtn);
        updt=findViewById(R.id.updation);
        Toast.makeText(cases.this, "Loading...", Toast.LENGTH_LONG).show();

        fdb= FirebaseDatabase.getInstance();
        db=fdb.getReference().child("cases");

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1=dataSnapshot.child("India").child("active").getValue().toString();
                String s2=dataSnapshot.child("India").child("cured").getValue().toString();
                String s3=dataSnapshot.child("India").child("deaths").getValue().toString();
                String s4=dataSnapshot.child("Telangana").child("active").getValue().toString();
                String s5=dataSnapshot.child("Telangana").child("cured").getValue().toString();
                String s6=dataSnapshot.child("Telangana").child("deaths").getValue().toString();
                String s7=dataSnapshot.child("Update").getValue().toString();
                String s8=dataSnapshot.child("Telangana recent").child("positive").getValue().toString();
                String s9=dataSnapshot.child("Telangana recent").child("cured").getValue().toString();
                String s10=dataSnapshot.child("Telangana recent").child("deaths").getValue().toString();
                String s11=dataSnapshot.child("India recent").child("positive").getValue().toString();
                String s12=dataSnapshot.child("India recent").child("cured").getValue().toString();
                String s13=dataSnapshot.child("India recent").child("deaths").getValue().toString();

                String s14=dataSnapshot.child("Telangana").child("total").getValue().toString();

                String s16=dataSnapshot.child("India").child("total").getValue().toString();


                ac1.setText(s1);
                ac2.setText(s4);
                ac4.setText(s11);
                inac4.setText(s12);
                dt4.setText(s13);
                tot1.setText(s16);
                tot3.setText(s14);
                inac1.setText(s2);
                inac2.setText(s5);
                dt1.setText(s3);
                dt2.setText(s6);
                dt3.setText(s10);
                ac3.setText(s8);
                inac3.setText(s9);
                updt.setText(s7);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total=Uri.parse("https://drive.google.com/file/d/1epiG0-2ykLCwblaGryKkD-lzhqLy3nFS/view?usp=sharing");
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,total);
                startActivity(intent);
            }
        });


    }

}
