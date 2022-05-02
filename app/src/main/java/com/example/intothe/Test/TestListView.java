package com.example.intothe.Test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.intothe.MainActivity;
import com.example.intothe.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class TestListView extends AppCompatActivity {

    TestList testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list_view);

        testList = new TestList();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, testList).commit();

    }

//    // 뒤로가기 버튼 눌렀을때, 홈화면으로 이동하기
//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent(StoreRecommend.this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        finish();
//    }
}
