package com.example.intothe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.Login.RegisterActivity;

public class FaceDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Face.db";
    private static final int DATABASE_VERSION = 2;
    //    private static final String TABLE_NAME = "practice_library";
    private static final String TABLE_NAME = "face" + RegisterActivity.userId;
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "testDate";
    private static final String COLUMN_SCORE_RIGHT = "rightScore";
    private static final String COLUMN_SCORE_WRONG = "wrongScore";


    public FaceDBHelper(@Nullable Context context)
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
                + COLUMN_SCORE_RIGHT + " INTEGER, "
                + COLUMN_SCORE_WRONG + " INTEGER); ";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addBook(String date, int right, int wrong)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_SCORE_RIGHT, right);
        cv.put(COLUMN_SCORE_WRONG, wrong);

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