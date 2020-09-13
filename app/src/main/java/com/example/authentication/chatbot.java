package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chatbot extends AppCompatActivity {
    Button mbtn;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot);
        mbtn=findViewById(R.id.chatbutton);
        uri = Uri.parse("https://api.whatsapp.com/send?phone=919000658658&amp;text=Hi&amp;source&amp;data&amp;app_absent&amp;lang=en"); // missing 'http://' will cause crashed
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
