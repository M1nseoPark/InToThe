package com.example.intothe.Test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.intothe.DatabaseHelper;
import com.example.intothe.R;

public class TestList extends Fragment {
    SQLiteDatabase database;
    ListView testList;
    TestListAdapter adapter;
    public static final String TAG ="TAG QuestionList.java";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_list, container, false);
        // 초기화, 참조 및 생성
        testList = (ListView) view.findViewById(android.R.id.list);
        openDB();

        // 리스트뷰 참조 및 Adapter 연결
        adapter = new TestListAdapter(getActivity());

        // 맨 처음 초기화 데이터 보여주기 (select)
        if (database != null) {
            String tableName = "test";
            String query = "select id, question, type from "+tableName;
            Cursor cursor = database.rawQuery(query, null);
            Log.v(TAG, "조회된 데이터 수 : " + cursor.getCount());

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String question = cursor.getString(1);
                String type = cursor.getString(2);

                adapter.addItem(new TestItem(id, question, type));
            }
            cursor.close();
        } else {
            Log.e(TAG, "selectData() db없음.");
        }
        testList.setAdapter(adapter);


//        // 가게 정보 상세보기
//        storeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getActivity(), StoreDetail.class);
//                StoreItem item = (StoreItem) adapter.getItem(i);
//                String id = String.valueOf(item.getStoreId());
//                Log.v(TAG, "id는" + id);
//                intent.putExtra("id", id);
//                startActivity(intent);
//            }
//        });

        return view;

    }

//    @Override
//    public void onListItemClick (ListView l, View v, int position, long id) {
//        StoreItem item = (StoreItem) l.getItemAtPosition(position) ;
//
//        String nameStr = item.getStoreName();
//        String gradeStr = item.getStoreGrade();
////        double distanceStr = item.getStoreDistance();
//        String logoStr = item.getStoreLogo();
//
//    }

//    public void addItem(String question) {
//        adapter.addItem(question);
//    }

    public void openDB() {
        Log.v(TAG, "openDB() 실행");
        DatabaseHelper helper = new DatabaseHelper(getContext());
        database = helper.getWritableDatabase();


        //Log.v(Double.toString(myLatitude), "위도");

        if (database != null) {
            Log.v(TAG, "DB 열기 성공!");
        } else {
            Log.e(TAG, "DB 열기 실패!");
        }
    }
}
