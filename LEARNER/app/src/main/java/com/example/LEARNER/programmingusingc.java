package com.example.LEARNER;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class programmingusingc extends AppCompatActivity {
    ImageView bookc,youtubec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmingusingc);

        bookc=findViewById(R.id.bookc1);
        youtubec=findViewById(R.id.youtubec);


        bookc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.pdfdrive.com/learn-to-program-with-c-learn-to-program-using-the-popular-c-programming-language-e166650744.html");
            }




        });
        youtubec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/vl794HKeXug");
            }




        });


    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}