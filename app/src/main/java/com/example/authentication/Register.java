package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.*;
import com.google.firebase.database.ValueEventListener;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText mEmail,mPassword,mFullName,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseDatabase fStore;
    String userID;
    DatabaseReference documentReference;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONE_NUMBER=
        Pattern.compile("\\d{10}|\\d{12}");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmail = findViewById(R.id.MailID2);
        mPassword = findViewById(R.id.Password);
        progressBar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        mRegisterBtn = findViewById(R.id.Registerbutton);
        mLoginBtn = findViewById(R.id.Notice);
        mFullName=findViewById(R.id.Fullname);
        mPhone=findViewById(R.id.Phone);
        fStore=FirebaseDatabase.getInstance();



        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();
                final String fullName = mFullName.getText().toString();
                final String phone    = mPhone.getText().toString();
                final String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
                Matcher matcher1 = VALID_PHONE_NUMBER.matcher(phone);
                if(!(matcher.find())){
                    mEmail.setError("Enter proper Email.");
                    return;
                }
                if(!(matcher1.find())){
                    mPhone.setError("Enter proper phone number.");
                    return;
                }


                if(TextUtils.isEmpty(phone)){
                    mPhone.setError("Phone number required");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);






                        documentReference = fStore.getReference().child("User");

                        documentReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (!dataSnapshot.child(phone).exists()) {

                                    // register the user in firebase

                                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                userID=fAuth.getUid();
                                                // send verification link
                                                Toast.makeText(Register.this, "Registered Successfully.", Toast.LENGTH_SHORT).show();

                                                fAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(Register.this, "Registered Successfully.Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                                            mEmail.setText("");
                                                            mPassword.setText("");
                                                        } else {
                                                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                            mEmail.setText("");
                                                            mPassword.setText("");
                                                            return;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    documentReference.child(phone).child("Date_Time").setValue(currentDateTimeString);
                                    documentReference.child(phone).child("Name").setValue(fullName);
                                    documentReference.child(phone).child("Email").setValue(email);
                                    documentReference.child(phone).child("Phone").setValue(phone);


                                    startActivity(new Intent(getApplicationContext(), Login.class));
                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(Register.this, "Already exits", Toast.LENGTH_SHORT).show();
                                    mPassword.setText("");
                                    mEmail.setText("");
                                    mPhone.setText("");
                                    mFullName.setText("");
                                    return;
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });



                    }
        });



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

    }
}
