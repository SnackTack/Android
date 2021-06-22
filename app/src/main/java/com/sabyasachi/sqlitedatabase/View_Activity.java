package com.sabyasachi.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class View_Activity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView = findViewById(R.id.view_list);

        DatabaseManager dm = new DatabaseManager( View_Activity.this);
        ArrayList<String> names = dm.getNames();
        ArrayList<String> prices = dm.getPrices();

        Adapter adapter = new Adapter(View_Activity.this, names, prices);



      //  String[] data = {"Fish Curry", "Chicken Curry", "Chicken Soup"};
        //ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }

}