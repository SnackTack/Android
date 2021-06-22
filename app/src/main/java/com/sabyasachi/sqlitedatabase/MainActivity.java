package com.sabyasachi.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add_btn, view_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       DatabaseManager dm = new DatabaseManager( MainActivity.this);

       // dm.insertData( "Veg Rice",  "80");

        add_btn = findViewById(R.id.add_btn);

        view_btn = findViewById(R.id.view_btn);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add_Activity.class);
                startActivity(intent);
            }
        });
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, View_Activity.class);
                startActivity(intent);

            }
        });
    }
}