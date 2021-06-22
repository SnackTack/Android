package com.sabyasachi.sqlitedatabase;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    ArrayList itemNames, itemPrices;

    Context c;
    LayoutInflater layoutInflater;

    TextView name, price;

    public Adapter(Context c, ArrayList names, ArrayList prices){
        this.c = c;
        this.itemNames = names;
        this.itemPrices = prices;
        this.layoutInflater = LayoutInflater.from(this.c);
    }
    @Override
    public int getCount() {
        return this.itemNames.size();
    }

    @Override
    public Object getItem(int i) {
        return this.itemNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String new_name = "";

        view = this.layoutInflater.inflate(R.layout.list, null);

        String itm_nm  = (String) getItem(i);

        String itm_price =(String) this.itemPrices.get(i);

        name = (TextView) view.findViewById(R.id.result_name);
        price = (TextView) view.findViewById(R.id.result_price);

        if (itm_nm.length() > 10){
            new_name = itm_nm.substring(0, 10);
            new_name += "...";
        } else {
            new_name = itm_nm;

        }

        name.setText(new_name);
        price.setText(itm_price);
        return  view;
    }
}
