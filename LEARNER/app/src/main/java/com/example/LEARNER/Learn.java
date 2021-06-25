package com.example.LEARNER;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Learn extends AppCompatActivity {

 ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        listview=findViewById(R.id.listview);
        String[] values=new String[]{
                "Programming using c","Python","Object oriented software engineering"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1,
        android.R.id.text1,values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                if(position==0)
                {
                    Intent intent=new Intent(view.getContext(),programmingusingc.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent=new Intent(view.getContext(),python.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent=new Intent(view.getContext(),oose.class);
                    startActivity(intent);
                }
            }

        });

}
}
