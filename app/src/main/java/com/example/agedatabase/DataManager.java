package com.example.agedatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {

    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_AGE = "age";

    private static final String DB_NAME = "name_age_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A = "name_and_age";

    public DataManager(Context context) {

        Log.i("TAG", "I'M AT DATAMANAGER1");

        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        Log.i("TAG", "I'M AT DATAMANAGER2");

        db = helper.getWritableDatabase();

        Log.i("TAG", "I'M AT DATAMANAGER3");
    }

    public void insert(String name, String age){

        Log.i("TAG", "I'M AT DATAMANAGER4");

        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_AGE +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + age + "'" +
                ");";

        Log.i("insert() = ", query);

        db.execSQL(query);
    }

    public void delete(String name) {

        String query = "DELETE FROM " + TABLE_N_AND_A +
                " WHERE " + TABLE_ROW_NAME +
                " = '" + name + "';";

        Log.i("delete() = ", query);

        db.execSQL(query);
    }

    public Cursor selectAll() {
        Cursor c = db.rawQuery("SELECT *" + " from " +
                TABLE_N_AND_A, null);

        return c;
    }

    public Cursor searchName(String name) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_AGE + " from " +
                TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';";

        Log.i("searchName() = ", query);

        Cursor c = db.rawQuery(query, null);

        return c;
    }

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String newTableQueryString = "create table " +
                    TABLE_N_AND_A + " (" +
                    TABLE_ROW_ID + " integer primary key autoincrement not null," +
                    TABLE_ROW_NAME + " text not null," +
                    TABLE_ROW_AGE + " text not null);";

            db.execSQL(newTableQueryString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
