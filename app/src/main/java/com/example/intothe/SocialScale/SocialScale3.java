package com.example.intothe.SocialScale;

import static com.example.intothe.SocialScale.SocialScale2.pick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class SocialScale3 extends AppCompatActivity {

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    public static int value1 = 0;
    public static int value2 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_scale_3);

        TextView tvExam1 = (TextView)findViewById(R.id.tvExam1);
        TextView tvExam2 = (TextView)findViewById(R.id.tvExam2);
        progressBar1 = (ProgressBar)findViewById(R.id.progressExam1);
        progressBar2 = (ProgressBar)findViewById(R.id.progressExam2);

        Button btnUp1 = (Button)findViewById(R.id.btnUp1);
        Button btnUp2 = (Button)findViewById(R.id.btnUp2);


        tvExam1.setText(SocialScale2.array.get(SocialScale2.pick).getExam1());
        tvExam2.setText(SocialScale2.array.get(SocialScale2.pick).getExam2());


        // 다음 버튼
        Button button = (Button) findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialScale4.class);
                startActivity(intent);
            }
        });
    }

    public void onClick1(View v) {
        value1 = value1 + 20;
        value2 = value2 - 20;
        progressBar1.setProgress(value1);
        progressBar2.setProgress(value2);
    }
    public void onClick2(View v) {
        value1 = value1 - 20;
        value2 = value2 + 20;
        progressBar1.setProgress(value1);
        progressBar2.setProgress(value2);
    }
}
