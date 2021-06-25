package com.example.LEARNER;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Continue extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.book_item:
                Intent myintent=new Intent(Continue.this,Learn.class);
                startActivity(myintent);

                return false;
            case R.id.learn_item:
                Intent myintent1=new Intent(Continue.this,Practice.class);
                startActivity(myintent1);

                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
