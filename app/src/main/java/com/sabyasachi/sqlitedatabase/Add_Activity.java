package com.sabyasachi.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Activity extends AppCompatActivity {

    EditText name, price;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);

        name = findViewById(R.id.input_name);
        price = findViewById(R.id.input_price);
        btn = findViewById(R.id.save_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item_name = name.getText().toString();
                String item_price = price.getText().toString();

                DatabaseManager dm = new DatabaseManager( Add_Activity.this);

                if(dm.insertData( item_name,  item_price)){
                    Toast.makeText(Add_Activity.this, "Data Saved!", Toast.LENGTH_SHORT).show();
                } else {
                   Toast.makeText(Add_Activity.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
                }

                name.setText("");
                price.setText("");

            }
        });
    }
}