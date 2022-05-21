package com.example.intothe.Test;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MainActivity;
import com.example.intothe.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestResult extends AppCompatActivity {

    long mNow;
    Date mDate;
    TextView tvMean;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_result);

        Button btScore = (Button) findViewById(R.id.btScore);
        TextView tvResult1 = (TextView) findViewById(R.id.tvResult1);
        TextView tvResult2 = (TextView) findViewById(R.id.tvResult2);
        ImageView btCancel = (ImageView) findViewById(R.id.cancel);
        barChart = (BarChart) findViewById(R.id.barchart);
        tvMean = (TextView) findViewById(R.id.tvMean);

        ResultDBHelper myDb = new ResultDBHelper(TestResult.this);
        SQLiteDatabase db = myDb.getReadableDatabase();


        // 테스트 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);

        // 버튼 누르면 홈으로
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 테스트 결과 보여주기
        String stScore = Integer.toString(TestListView.score);
        btScore.setText("총점\n" + stScore + "점");

        if (TestListView.score <= 90) {
            tvResult1.setText("정상 수준");
            tvResult2.setText("자폐적 특성이 전혀 없거나 거의 없습니다.");
        }
        else {
            tvResult1.setText("가능성이 있습니다");
            tvResult2.setText("아동 자폐증이나 사회적 의사소통\n어려움의 가능성이 있습니다.\n본 검사는 진단이 아닌 선별검사일 뿐\n정확한 진단은 전문의를 통해\n상담하셔야 합니다.");
        }

        // 점수 db에 추가
//        myDb.addBook(mFormat.format(mDate), TestListView.score);


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
