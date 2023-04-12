package com.example.intothe.controller.Test;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.util.Consumer;

import com.bumptech.glide.Glide;
import com.example.intothe.R;

import java.util.ArrayList;

public class TestItemView extends LinearLayout {

    TextView tvQuestion;
    Button btOne;
    Button btTwo;
    Button btThree;
    Button btFour;
    Button btFive;

    private Consumer<Integer> answerClickListener;

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

        btOne = (Button) findViewById(R.id.btOne);
        btTwo = (Button) findViewById(R.id.btTwo);
        btThree = (Button) findViewById(R.id.btThree);
        btFour = (Button) findViewById(R.id.btFour);
        btFive = (Button) findViewById(R.id.btFive);

        btOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btOne.setSelected(true);
                btTwo.setSelected(false);
                btThree.setSelected(false);
                btFour.setSelected(false);
                btFive.setSelected(false);

                if (answerClickListener != null) {
                    answerClickListener.accept(1);
                }
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

                if (answerClickListener != null) {
                    answerClickListener.accept(2);
                }
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

                if (answerClickListener != null) {
                    answerClickListener.accept(3);
                }
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

                if (answerClickListener != null) {
                    answerClickListener.accept(4);
                }
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

                if (answerClickListener != null) {
                    answerClickListener.accept(5);
                }
            }
        });
    }

    public void setAnswerClickListener(Consumer<Integer> answerClickListener) {
        this.answerClickListener = answerClickListener;
    }

    public void setQuestion(String question){
        tvQuestion.setText(question);
    }   // name

    public void setAnswer(String answer) {
        btOne.setSelected(false);
        btTwo.setSelected(false);
        btThree.setSelected(false);
        btFour.setSelected(false);
        btFive.setSelected(false);

        try {
            int index = Integer.parseInt(answer);

            switch (index) {
                case 1:
                    btOne.setSelected(true);
                    break;
                case 2:
                    btTwo.setSelected(true);
                    break;
                case 3:
                    btThree.setSelected(true);
                    break;
                case 4:
                    btFour.setSelected(true);
                    break;
                case 5:
                    btFive.setSelected(true);
                    break;
            }
        } catch (Exception e) {
        }
    }
}
