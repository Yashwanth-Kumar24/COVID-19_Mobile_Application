package com.example.authentication;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class controlroom extends AppCompatActivity {
    TextView police,health,control1,control2;
    LinearLayout dist,dept;
    Uri discnt,dptcnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controlroom);
        police = (TextView) findViewById(R.id.law);
        health = (TextView) findViewById(R.id.hlth);
        control1 = (TextView) findViewById(R.id.canum1);
        control2 = (TextView) findViewById(R.id.canum2);
        dist=findViewById(R.id.distwise);
        dept=findViewById(R.id.deptwise);

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = police.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(controlroom.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num=health.getText().toString().trim();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(controlroom.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        control1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = control1.getText().toString().trim();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(controlroom.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        control2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String num = control2.getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(controlroom.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intent);
                }
            }
        });
        discnt=Uri.parse("https://drive.google.com/file/d/1bopoh7taK_HLHPRknCKMrBux6fGUhpL2/view?usp=sharing");
        dist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, discnt);
                startActivity(intent);
            }
        });
        dptcnt=Uri.parse("https://drive.google.com/file/d/1xCJP54xhGVIdxBsa6-YjSXPWkl5bJsJm/view?usp=sharing");
        dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, dptcnt);
                startActivity(intent);
            }
        });
    }
    private void requestPermission()
    {
        ActivityCompat.requestPermissions(controlroom.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }



}
