package com.example.a124lttd04_travelappproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a124lttd04_travelappproject.R;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TravelApp.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_HOTEL = "KHACHSAN";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "tenkhachsan";
    public static final String COLUMN_IMAGE = "hinhanh";
    public static final String COLUMN_PRICE = "giasale";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_HOTEL + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_IMAGE + " INTEGER, " +
                COLUMN_PRICE + " TEXT)";
        db.execSQL(createTable);

        // Thêm dữ liệu mẫu
        db.execSQL("INSERT INTO " + TABLE_HOTEL + " (tenkhachsan, hinhanh, giasale) VALUES ('PITACHIDO Hotel', " + R.drawable.a3 + ", '1.050.000₫')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL);
        onCreate(db);
    }
}
