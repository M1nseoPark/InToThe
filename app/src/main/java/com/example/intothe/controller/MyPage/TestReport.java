package com.example.intothe.controller.MyPage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.databinding.TestReportBinding;
import com.example.intothe.model.FaceDBHelper;
import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.model.ResultDBHelper;
import com.example.intothe.controller.TestPick;

import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.StackedBarModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestReport extends AppCompatActivity {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("MM-dd");

    private TestReportBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TestReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ResultDBHelper myDb = new ResultDBHelper(TestReport.this);
        SQLiteDatabase db = myDb.getReadableDatabase();
        FaceDBHelper myDb2 = new FaceDBHelper(TestReport.this);
        SQLiteDatabase db2 = myDb2.getReadableDatabase();


        //////////////////////////////////////

        // 테스트 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);

        myDb2.addBook(mFormat.format(mDate), TestPick.right, TestPick.wrong);


        ArrayList<String> dateList2 = new ArrayList<String>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();
        ArrayList<Integer> wrongList = new ArrayList<Integer>();

        // select db
        String sql2 = "select * from face" + LoginActivity.userId;
        Cursor cursor2 = db2.rawQuery(sql2, null);
        while(cursor2.moveToNext()){
            dateList2.add(cursor2.getString(1));
            rightList.add(cursor2.getInt(2));
            wrongList.add(cursor2.getInt(3));
        }

        myDb2.close();
        db2.close();
        cursor2.close();


        // show stacked barchart
        binding.stackedbarchart.clearChart();

        for (int i = 0; i < dateList2.size(); i++) {
            StackedBarModel s1 = new StackedBarModel(dateList2.get(i));
            s1.addBar(new BarModel(rightList.get(i), 0xFF875FC0));
            s1.addBar(new BarModel(wrongList.get(i), 0xFFEB4985));
            binding.stackedbarchart.addBar(s1);
        }

        binding.stackedbarchart.startAnimation();


        //////////////////////////////////////
        ArrayList<String> dateList = new ArrayList<String>();
        ArrayList<Integer> scoreList = new ArrayList<Integer>();
        int sumScore = 0;

        // select db
        String sql = "select * from result" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            dateList.add(cursor.getString(1));
            scoreList.add(cursor.getInt(2));
        }

        myDb.close();
        db.close();
        cursor.close();

        // show barChart
        binding.barchart.clearChart();

        for (int i = 0; i < dateList.size(); i++) {
            sumScore += scoreList.get(i);
            binding.barchart.addBar(new BarModel(dateList.get(i), scoreList.get(i), 0xFFFFBDBE));
        }
        binding.barchart.startAnimation();


        // show meanScore
        binding.tvMean.setText("평균 " + Float.toString(sumScore / scoreList.size()) + "점");
    }
}
