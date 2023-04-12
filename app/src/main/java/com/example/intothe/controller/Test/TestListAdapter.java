package com.example.intothe.controller.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.intothe.model.TestItem;

import java.util.ArrayList;
import java.util.List;

public class TestListAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    public static ArrayList<TestItem> items = new ArrayList<TestItem>();


    public TestListAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void addItem(TestItem item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removeItemAll(){
        items.clear();
        notifyDataSetChanged();
    }

    public List<TestItem> getItems() {
        return items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestItemView view = null;
        if (convertView == null) {
            view = new TestItemView(mContext);
        } else {
            view = (TestItemView) convertView;
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        TestItem item = items.get(position);

        view.setAnswerClickListener(answer -> {
            item.setAnswer(answer.toString());
        });

        //데이터 값 표시하기
        view.setQuestion(item.getQuestion());
        view.setAnswer(item.getAnswer());

        return view;
    }
}
