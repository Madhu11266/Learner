package com.example.LEARNER;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class python extends AppCompatActivity {
    ImageView bookc,youtubec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);

        bookc=findViewById(R.id.bookc1);
        youtubec=findViewById(R.id.youtubec);


        bookc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.pdfdrive.com/learn-python-in-one-day-and-learn-it-well-python-for-beginners-with-hands-on-project-the-only-book-you-need-to-start-coding-in-python-immediately-e183833259.html");
            }




        });
        youtubec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/WGJJIrtnfpk");
            }




        });


    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}