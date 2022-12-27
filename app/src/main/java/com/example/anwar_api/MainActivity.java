package com.example.anwar_api;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        Button butt=(Button)findViewById(R.id.but1);
        txt=findViewById(R.id.jsondata);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonData object=new JsonData();
                object.execute();

            }
        });
    }
}