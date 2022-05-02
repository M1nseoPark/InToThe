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

//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.addTab(tabs.newTab().setText("매장"));
//        tabs.addTab(tabs.newTab().setText("배달"));
//
//        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                int position = tab.getPosition();
//                Log.d("StoreRecommend", "선택된 탭 : " + position);
//
//                Fragment selected = null;
//                if (position == 0) {
//                    selected = testList;
//                } else if (position == 1) {
//                    selected = testList;
//                }
//
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container, selected).commit();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) { }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) { }
//        });

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
