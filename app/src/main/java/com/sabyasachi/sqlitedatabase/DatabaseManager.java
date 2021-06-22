package com.sabyasachi.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    private static  final  int DATABASE_VERSION = 1;

    private  static  final  String DATABASE_NAME = "database";

    private static final String TABLE_NAME = "dish_item";

    private  static final String KEY_NAME = "item_name";

    private  static final String KEY_PRICE = "item_price";


    public DatabaseManager(@Nullable Context context)  {
        super(context, DATABASE_NAME,  null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + "id" + " integer PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " text, " + KEY_PRICE + " varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

     onCreate(sqLiteDatabase);
    }


    public  boolean insertData(String name, String price) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put (KEY_NAME, name);
        contentValues.put (KEY_PRICE, price);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            db.close();
            return  false;
        }else{
            db.close();
            return  true;
        }
    }

    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.query(TABLE_NAME, new String[]{KEY_NAME}, null, null, null, null,null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(KEY_NAME);
            names.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return names;
    }

    public ArrayList<String> getPrices() {
        ArrayList<String> prices = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.query(TABLE_NAME, new String[]{KEY_PRICE}, null, null, null, null,null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(KEY_PRICE);
            prices.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return  prices ;
}}
