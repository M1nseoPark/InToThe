package com.example.intothe.MyPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class SettingCode extends AppCompatActivity {

    public static String code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_code);

        ImageView back = (ImageView) findViewById(R.id.back);
        EditText et1 = (EditText) findViewById(R.id.et_1);
        EditText et2 = (EditText) findViewById(R.id.et_2);
        EditText et3 = (EditText) findViewById(R.id.et_3);
        EditText et4 = (EditText) findViewById(R.id.et_4);

        // 뒤로 가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

        code += et1.getText();
        code += et2.getText();
        code += et3.getText();
        code += et4.getText();
    }
}
