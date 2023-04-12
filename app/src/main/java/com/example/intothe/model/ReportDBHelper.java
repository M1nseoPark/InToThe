package com.example.intothe.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.intothe.controller.Login.RegisterActivity;

public class ReportDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Report.db";
    private static final int DATABASE_VERSION = 7;
    //    private static final String TABLE_NAME = "practice_library";
    private static final String TABLE_NAME = "report" + RegisterActivity.userId;
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "trainDate";
    private static final String COLUMN_NAME_1 = "trainName1";
    private static final String COLUMN_SPECIAL_1 = "trainSpecial1";
    private static final String COLUMN_CONTENT_1 = "trainContent1";
    private static final String COLUMN_NAME_2 = "trainName2";
    private static final String COLUMN_SPECIAL_2 = "trainSpecial2";
    private static final String COLUMN_CONTENT_2 = "trainContent2";
    private static final String COLUMN_NAME_3 = "trainName3";
    private static final String COLUMN_SPECIAL_3 = "trainSpecial3";
    private static final String COLUMN_CONTENT_3 = "trainContent3";

    public ReportDBHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_NAME_1 + " TEXT, "
                + COLUMN_SPECIAL_1 + " TEXT, "
                + COLUMN_CONTENT_1 + " TEXT, "
                + COLUMN_NAME_2 + " TEXT, "
                + COLUMN_SPECIAL_2 + " TEXT, "
                + COLUMN_CONTENT_2 + " TEXT, "
                + COLUMN_NAME_3 + " TEXT, "
                + COLUMN_SPECIAL_3 + " TEXT, "
                + COLUMN_CONTENT_3 + " TEXT); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addBook(String trainDate, String trainName1, String trainSpecial1, String trainContent1,
                        String trainName2, String trainSpecial2, String trainContent2, String trainName3, String trainSpecial3, String trainContent3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE, trainDate);
        cv.put(COLUMN_NAME_1, trainName1);
        cv.put(COLUMN_SPECIAL_1, trainSpecial1);
        cv.put(COLUMN_CONTENT_1, trainContent1);
        cv.put(COLUMN_NAME_2, trainName2);
        cv.put(COLUMN_SPECIAL_2, trainSpecial2);
        cv.put(COLUMN_CONTENT_2, trainContent2);
        cv.put(COLUMN_NAME_3, trainName3);
        cv.put(COLUMN_SPECIAL_3, trainSpecial3);
        cv.put(COLUMN_CONTENT_3, trainContent3);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "데이터 추가 성공", Toast.LENGTH_SHORT).show();
        }
    }
}
