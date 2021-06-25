package com.example.LEARNER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    Button logout,con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        con= (Button) findViewById(R.id.button);

        con.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(HomeScreen.this,Continue.class);
                startActivity(i);

            }
        });

        logout = (Button)findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(HomeScreen.this,MainActivity.class);
                startActivity(i);

            }
        });




    }
}