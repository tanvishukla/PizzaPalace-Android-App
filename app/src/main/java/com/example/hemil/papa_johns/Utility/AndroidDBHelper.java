package com.example.hemil.papa_johns.Utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.hemil.papa_johns.POJO.Order;

import java.util.ArrayList;

/**
 * Created by hemil on 12/4/2015.
 */
public class AndroidDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "OrderDB";
    public static final int VERSION = 1;

    public static final String TABLE_NAME = "order_details_table";

 /*   public static final String STREET_NAME = "street_name";
    public static final String APT_NUM = "apt_number";
    public static final String CITY = "city";
    public static final String ZIPCODE = "zipcode";
    public static final String STATE = "state";

    String CREATE_TABLE_QUERY = "create table if not exists "+ TABLE_NAME + " ( " + BaseColumns._ID + " integer primary key autoincrement,"
            +STREET_NAME + " text not null " + APT_NUM+ " text not null "+ CITY +" text not null "+ZIPCODE+" text not null "
            + STATE+ " text not null";

    String UPDATE_QUERY = "";
*/

    public static final String ORDER_NAME = "order_name";
    public static final String COST = "cost";

    String CREATE_TABLE_QUERY = " create table if not exists " + TABLE_NAME + " ( " + BaseColumns._ID + " integer primary key autoincreament, "
            + ORDER_NAME + " text not null ," + COST + " double not null";

    public AndroidDBHelper(Context context){

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean addOrder(String order, double cost){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_NAME,order);
        contentValues.put(COST, cost);

        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public ArrayList<Order> getOrders(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        ArrayList<Order> list = new ArrayList<>();
        cursor.moveToFirst();

        while(cursor.moveToNext()){

            String order = cursor.getString(cursor.getColumnIndex(this.ORDER_NAME));
            double cost = cursor.getDouble(cursor.getColumnIndex(this.COST));

         Order orderclass = new Order();
            orderclass.setOrderName(order);
            orderclass.setCost(cost);
            list.add(orderclass);
        }
        return list;

    }
 /*
    public boolean addAddress(String street, String apt, String city, String zip, String state){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STREET_NAME,street);
        contentValues.put(APT_NUM,apt);
        contentValues.put(CITY,city);
        contentValues.put(ZIPCODE,zip);
        contentValues.put(STATE, state);

        db.insert(TABLE_NAME,null,contentValues);
        return true;
    }

    public ArrayList<Address> getAddresses(){
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        ArrayList<Address> list = new ArrayList<>();
        cursor.moveToFirst();

        while(cursor.moveToNext()){
           String street = cursor.getString(cursor.getColumnIndex(this.STREET_NAME));
            String apt = cursor.getString(cursor.getColumnIndex(this.APT_NUM));
            String city = cursor.getString(cursor.getColumnIndex(this.CITY));
            String zip = cursor.getString(cursor.getColumnIndex(this.ZIPCODE));
            String state = cursor.getString(cursor.getColumnIndex(this.STATE));

            Address address = new Address();
            address.setStreetName(street);
            address.setAptNum(apt);
            address.setCity(city);
            address.setZipCode(zip);
            address.setState(state);

            list.add(address);
        }
        return list;
    }
*/




}