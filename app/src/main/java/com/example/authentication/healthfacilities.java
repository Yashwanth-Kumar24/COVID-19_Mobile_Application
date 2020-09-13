package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class healthfacilities extends AppCompatActivity {

    LinearLayout quar,test,isolate,Lochsp;

    Uri quarantine,testing,isolation,hsptls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthfacilities);
        quar=findViewById(R.id.quarantine);
        test=findViewById(R.id.testing);
        isolate=findViewById(R.id.isolation);
        Lochsp=findViewById(R.id.hsptlsBtn);

        quarantine=Uri.parse("https://drive.google.com/file/d/1DFClQiFFmIUXdVqT8m38iPTYUziIKYCt/view?usp=sharing");
        quar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, quarantine);
                startActivity(intent);
            }
        });
        testing=Uri.parse("https://drive.google.com/file/d/15OsZjSSZG_SjDKFVvRT0DBZQot8nlajU/view?usp=sharing");
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, testing);
                startActivity(intent);
            }
        });
        isolation=Uri.parse("https://drive.google.com/file/d/1OM99JKrChWh0JY1qh1XPjkGMMMx9F8yD/view?usp=sharing");
        isolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, isolation);
                startActivity(intent);
            }
        });
        hsptls=Uri.parse("https://www.google.com/maps/search/hospitals+nearby");
        Lochsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, hsptls);
                startActivity(intent);
            }
        });



    }
}
