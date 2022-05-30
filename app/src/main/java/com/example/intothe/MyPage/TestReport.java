package com.example.intothe.MyPage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.FaceDBHelper;
import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.Test.ResultDBHelper;
import com.example.intothe.Test.TestListView;
import com.example.intothe.Test.TestResult;
import com.example.intothe.TestPick;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.StackedBarChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.StackedBarModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestReport extends AppCompatActivity {

    long mNow;
    Date mDate;
    TextView tvMean;
    SimpleDateFormat mFormat = new SimpleDateFormat("MM-dd");
    BarChart barChart;
    StackedBarChart mStackedBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_report);

        mStackedBarChart = (StackedBarChart) findViewById(R.id.stackedbarchart);
        barChart = (BarChart) findViewById(R.id.barchart);
        tvMean = (TextView) findViewById(R.id.tvMean);

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
        mStackedBarChart.clearChart();

        for (int i = 0; i < dateList2.size(); i++) {
            StackedBarModel s1 = new StackedBarModel(dateList2.get(i));
            s1.addBar(new BarModel(rightList.get(i), 0xFF875FC0));
            s1.addBar(new BarModel(wrongList.get(i), 0xFFEB4985));
            mStackedBarChart.addBar(s1);
        }

        mStackedBarChart.startAnimation();


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
        barChart.clearChart();

        for (int i = 0; i < dateList.size(); i++) {
            sumScore += scoreList.get(i);
            barChart.addBar(new BarModel(dateList.get(i), scoreList.get(i), 0xFFFFBDBE));
        }
        barChart.startAnimation();


        // show meanScore
        tvMean.setText("평균 " + Float.toString(sumScore / scoreList.size()) + "점");
    }
}
