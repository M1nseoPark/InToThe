package com.example.intothe.Test;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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

        Button btOne = (Button) findViewById(R.id.btOne);
        Button btTwo = (Button) findViewById(R.id.btTwo);
        Button btThree = (Button) findViewById(R.id.btThree);
        Button btFour = (Button) findViewById(R.id.btFour);
        Button btFive = (Button) findViewById(R.id.btFive);

        btOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btOne.setSelected(true);
                btTwo.setSelected(false);
                btThree.setSelected(false);
                btFour.setSelected(false);
                btFive.setSelected(false);
            }
        });

        btTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btOne.setSelected(false);
                btTwo.setSelected(true);
                btThree.setSelected(false);
                btFour.setSelected(false);
                btFive.setSelected(false);
            }
        });

        btThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btOne.setSelected(false);
                btTwo.setSelected(false);
                btThree.setSelected(true);
                btFour.setSelected(false);
                btFive.setSelected(false);
            }
        });

        btFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btOne.setSelected(false);
                btTwo.setSelected(false);
                btThree.setSelected(false);
                btFour.setSelected(true);
                btFive.setSelected(false);
            }
        });

        btFive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btOne.setSelected(false);
                btTwo.setSelected(false);
                btThree.setSelected(false);
                btFour.setSelected(false);
                btFive.setSelected(true);
            }
        });
    }

    public void setQuestion(String question){
        tvQuestion.setText(question);
    }   // name
}
