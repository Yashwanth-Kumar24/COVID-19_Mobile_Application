package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class helpline extends AppCompatActivity {
    LinearLayout stateutsBtn;
    TextView mhn,apn,kan1,kan2,chtn1,chtn2;
    Uri numbersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
        mhn = (TextView) findViewById(R.id.mhnum1);
        apn = (TextView) findViewById(R.id.apnum1);
        chtn2 = (TextView) findViewById(R.id.chtnum2);
        chtn1 = (TextView) findViewById(R.id.chtnum1);
        kan1 = (TextView) findViewById(R.id.kanum1);
        kan2 = (TextView) findViewById(R.id.kanum2);
        stateutsBtn=findViewById(R.id.numbersBtn);


        mhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = mhn.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(helpline.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        apn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num=apn.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(helpline.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        kan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = kan1.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(helpline.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        kan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = kan2.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(helpline.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        chtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = chtn1.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(helpline.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        chtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = chtn2.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(helpline.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });

        numbersList=Uri.parse("https://drive.google.com/file/d/1tBAbRsSDf12tUUjWqWfy4SS1PjaRp__r/view?usp=sharing");
        stateutsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, numbersList);
                startActivity(intent);
            }
        });

    }
    private void requestPermission()
    {
        ActivityCompat.requestPermissions(helpline.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }



}
