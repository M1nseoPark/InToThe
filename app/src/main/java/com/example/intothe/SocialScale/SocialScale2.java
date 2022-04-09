package com.example.intothe.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.intothe.R;
import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Random;

public class SocialScale2 extends AppCompatActivity {

    ArrayList<Situation> array = new ArrayList<Situation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_scale_2);

        ImageView socialImage = (ImageView)findViewById(R.id.imageView1);
        TextView tvSituation = (TextView)findViewById(R.id.tvSituation);

        array.add(new Situation("네가 학교 교실에 앉아 있는데,\n네 옆에 앉은 남자아이가 책상을 치기\n시작했어", "적절하다", "적절하지 않다", 2, "http://drive.google.com/uc?export=view&id=1rZlTmrnSA7yKdu78ZQS6ENMKZXpZB8N5"));
        array.add(new Situation("네가 학교에서 복도를 걸어오고 있는데,\n다른 학생이 네 옆을 지나가면서\n너를 밀었어", "괴롭히는 것이다", "괴롭히는 것이 아니다", 1, "http://drive.google.com/uc?export=view&id=1rZlTmrnSA7yKdu78ZQS6ENMKZXpZB8N5"));
        array.add(new Situation("버스에서 네 친구가 무거운 짐을 든\n할머니께 자리를 양보해드렸어", "옳다", "옳지 않다", 1, "http://drive.google.com/uc?export=view&id=1rqpBkPUrwvNjpJQbW2VqA5BfEJVbe7av"));
        array.add(new Situation("네가 친구집에 놀러갔는데,\n친구가 가지고 있는 인형이 너무 귀여워서\n친구 몰래 가져왔어", "친구니까 괜찮다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1rqpBkPUrwvNjpJQbW2VqA5BfEJVbe7av"));
        array.add(new Situation("호랑나비 흰나비 춤을 추며 오너라.\n봄바람에 꽃잎도 방긋방긋 웃으며\n참새도 짹짹짹 노래하며 춤춘다", "즐겁다", "불쾌하다", 1, "http://drive.google.com/uc?export=view&id=1hugu0qpLEU2qn_TUr1bM_4AvcczXahtB"));
        array.add(new Situation("영어 시험에서\n네가 앞에 앉은 친구 답안지를 베껴서\n100점을 맞았어", "괜찮다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1hugu0qpLEU2qn_TUr1bM_4AvcczXahtB"));
        array.add(new Situation("지하철에서 오랜만에\n친구한테 전화가 와서 큰소리로 통화했어", "옳다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1SdpBZyxPlSasRjCt8-wTpU2AvRAG5FFw"));
        array.add(new Situation("너무 더워서 아이스크림을 사먹었는데,\n주변에 쓰레기통이 없어서 아이스크림\n껍질을 바닥에 그냥 버렸어", "옳다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1SdpBZyxPlSasRjCt8-wTpU2AvRAG5FFw"));
        array.add(new Situation("네가 키우는 강아지보다\n친구가 키우는 강아지가 더 귀여워서\n네 강아지는 동물보호소에 버리고\n강아지를 새로 샀어", "옳다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1HW0CMiuwAF8zK56BW2b3tX1b-QCB7q8D"));
        array.add(new Situation("치킨이 먹고 싶은데 용돈을 다 써서\n엄마 지갑에서 돈을 몰래 꺼내서 치킨을\n사먹었어", "괜찮다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1HW0CMiuwAF8zK56BW2b3tX1b-QCB7q8D"));

        Random rand = new Random();
        int pick = rand.nextInt(10);

        tvSituation.setText(array.get(pick).getSituation());
        Glide.with(this).load(array.get(pick).getPhoto()).error(R.drawable.test).into(socialImage);


        // 다음 버튼
        Button button = (Button) findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialScale3.class);
                startActivity(intent);
            }
        });
    }
}
