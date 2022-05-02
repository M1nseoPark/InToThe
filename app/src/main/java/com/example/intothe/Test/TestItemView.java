package com.example.intothe.Test;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.intothe.R;

public class TestItemView extends LinearLayout {

    TextView tvQuestion;


    public TestItemView(Context context){
        super(context);
        init(context);
    }

    public TestItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.test_item, this, true);

        tvQuestion = findViewById(R.id.tvQuestion);
    }

    public void setQuestion(String question){
        tvQuestion.setText(question);
    }   // name
}
