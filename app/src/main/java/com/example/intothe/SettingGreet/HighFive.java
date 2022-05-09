package com.example.intothe.SettingGreet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.ChangeFace2.ChangeFace21;
import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MainActivity;
import com.example.intothe.R;
import com.example.intothe.UserDBHelper;

public class HighFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highfive);

        TextView tvGreeting = (TextView) findViewById(R.id.tvGreeting);
        Button btHand1 = (Button) findViewById(R.id.btHand1);
        Button btHand2 = (Button) findViewById(R.id.btHand2);


        String stGreeting = "";

        // db start
        UserDBHelper myDb = new UserDBHelper(HighFive.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        String sql = "select * from user where _id=" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            stGreeting = cursor.getString(4);
        }

        myDb.close();
        db.close();
        cursor.close();


        // 인사 진행
        tvGreeting.setText(stGreeting);

        btHand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace21.class);
                startActivity(intent);
            }
        });

        btHand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace21.class);
                startActivity(intent);
            }
        });
    }
}
