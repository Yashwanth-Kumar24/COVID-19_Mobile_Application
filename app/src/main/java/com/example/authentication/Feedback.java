package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {
    EditText sgt,ftrs,rtng;
    Button submit;
    String sgg,ft,rt;
    double rating;
    FirebaseDatabase fb;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        sgt=findViewById(R.id.suggest);
        ftrs=findViewById(R.id.features);
        rtng=findViewById(R.id.rating);
        submit=findViewById(R.id.submitBtn);

        fb=FirebaseDatabase.getInstance();

        db=fb.getReference();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sgg=sgt.getText().toString().trim();
                ft=ftrs.getText().toString().trim();

                try{
                    rt=rtng.getText().toString().trim();
                    rating=Double.parseDouble(rt);
                }
                catch (Exception e){
                    rtng.setError("Enter a number 1-5");
                }
                if(!(rating>=0.0 && rating<=5.0)){
                    rtng.setError("Please enter a valid number 1-5");
                    return;
                }

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String put1=dataSnapshot.child("Feedback").child("len").getValue().toString();
                        int puts=Integer.parseInt(put1)+1;
                        String put=Integer.toString(puts);
                        db.child("Feedback").child(put).child("Suggestions").setValue(sgg);
                        db.child("Feedback").child(put).child("Features").setValue(ft);
                        db.child("Feedback").child(put).child("Rating").setValue(rating);
                        db.child("Feedback").child("len").setValue(put);

                        Toast.makeText(Feedback.this, "Thank you\nStay Home...Stay Safe", Toast.LENGTH_SHORT).show();
                        sgt.setText("");
                        ftrs.setText("");
                        rtng.setText("");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
});
    }
}


