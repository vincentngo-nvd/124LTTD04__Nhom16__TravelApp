package com.example.a124lttd04_travelappproject.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_CategoryHotel2_Home_Model;

import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    private DatabaseHelper dbHelper;

    public HotelDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public List<hotel_CategoryHotel2_Home_Model> getAllHotels() {
        List<hotel_CategoryHotel2_Home_Model> hotelList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_HOTEL, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                int image = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGE));
                String price = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRICE));

                hotelList.add(new hotel_CategoryHotel2_Home_Model(image, name, price, R.drawable.rating));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return hotelList;
    }
}
