package com.example.intothe.controller.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.intothe.R;
import com.example.intothe.databinding.SocialScale2Binding;
import com.example.intothe.model.SocialScale_Situation;

import java.util.ArrayList;

public class SocialScale2 extends AppCompatActivity {

    public static ArrayList<SocialScale_Situation> array = new ArrayList<SocialScale_Situation>();
    public static int pick;

    private SocialScale2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SocialScale2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        array.add(new SocialScale_Situation("네가 학교 교실에 앉아 있는데, 네 옆에 앉은 남자아이가 책상을 치기 시작했어", "적절하다", "적절하지 않다", 2, "http://drive.google.com/uc?export=view&id=1SM7GTyqFGGL6tmacuhMFkHTQW_RaOs8t", "교실에 공부하는 친구들도 있을텐데 책상을 치면 시끄럽겠지? 너도 공부하는데 누가 시끄러운 소리를 내면 집중이 잘 안되지 않아? 책상을 치는 건 잘못된 행동이야"));
        array.add(new SocialScale_Situation("친구가 학교에서 복도를 걸어오고 있는데, 너가 옆을 지나가면서 친구를 밀었어", "괴롭히는 것이다", "괴롭히는 것이 아니다", 1, "http://drive.google.com/uc?export=view&id=1TZ0Tah9t3MmZG1ThJbxYnhNJb3pJVG3a", "친구를 갑자기 밀면 친구가 위험한 곳으로 넘어져서 크게 다칠 수도 있겠지? 만약 달리는 자동차 앞에 넘어진다면 큰 사고가 날거야 친구를 밀면 절대 안돼"));
        array.add(new SocialScale_Situation("버스에서 네 친구가 무거운 짐을 든 할머니께 자리를 양보해드렸어", "옳다", "옳지 않다", 1, "http://drive.google.com/uc?export=view&id=1ZLKPbJgrN3fmx2217srfncFjer5CxChx", "노인분들은 우리보다 훨씬 힘이 없으셔. 게다가 짐까지 들고 계시면 정말 힘드실거야. 앉아 있고 싶은 마음을 참고 자리를 양보한 친구의 행동은 배려심이 넘치는 행동이라고 생각해"));
        array.add(new SocialScale_Situation("네가 친구집에 놀러갔는데, 친구가 가지고 있는 볼펜이 너무 귀여워서 친구 몰래 가져왔어", "친구니까 괜찮다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1kv6E9Vo5wPiHSzlTA4-TSkDvQQdQtikt", "너가 제일 아끼는 물건을 떠올려봐! 그걸 잃어버리면 어떨 것 같아? 정말 속상하겠지? 친구집에 있는 물건은 너가 아끼는 물건처럼 소중히 대해줘야 돼. 말도 안하고 가져온다는 것은 정말 잘못된 행동이야."));
        array.add(new SocialScale_Situation("호랑나비 흰나비 춤을 추며 오너라. 봄바람에 꽃잎도 방긋방긋 웃으며 참새도 짹짹짹 노래하며 춤춘다", "즐겁다", "불쾌하다", 1, "http://drive.google.com/uc?export=view&id=14iL9irBcdChMPJx0TygAeeaXr6GXEiwU", "봄봄봄 봄이 왔네요~ 파란 하늘, 산들거리는 바람, 예쁘게 핀 꽃. 생각만 해도 기분이 좋아지지 않니? 나는 비오는 날에는 털도 젖고 눅눅해서 싫은데 날씨가 좋은 날엔 어디든 나가고 싶더라-!"));
        array.add(new SocialScale_Situation("영어 시험에서 네가 옆에 앉은 친구 답안지를 베껴서 100점을 맞았어", "괜찮다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1XfamH_JQ66JX-aHvLuCYUw_r1qQIvD_m", "친구 답안지를 베껴서 잘 나온 성적이 과연 진짜 너의 실력일까? 100점을 받아도 너의 행동이 들킬까봐 조마조마하지 않을까? 점수를 잘 받고 싶은 건 이해하지만 너가 베껴서 잘 받은 100점보다 너의 실력으로 받은 90점이 더 떳떳하고 자랑스러울걸?"));
        array.add(new SocialScale_Situation("지하철에서 오랜만에 친구한테 전화가 와서 큰소리로 통화했어", "옳다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1zsA4uCarDz085O1xBxpVQLy3efWR4eY5", "공공장소에서의 시끄러운 통화소리는 너가 조용히 쉬고 싶을 때 울리는 시끄러운 음악소리와 같아. 지하철에는 힘든 하루를 보내고 조용히 쉬고 싶은 사람이 많아. 꼭 필요한 전화라면 조용히 통화하고 그렇지 않으면 내려서 받는게 좋아"));
        array.add(new SocialScale_Situation("너무 더워서 아이스크림을 사먹었는데, 주변에 쓰레기통이 없어서 아이스크림 껍질을 바닥에 그냥 버렸어", "옳다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=14qZ69iz_t4OnXTV5xFBfz9hSr8Y3kest", "누가 너의 방에 쓰레기를 버리면 불쾌하지? 바닥에 쓰레기를 버리는 것도 마찬가지야. 거리는 모든 사람들이 사용하는 공용 장소야. 게다가 너가 버린 쓰레기들은 다른 사람이 힘들게 치워야돼 꼭 쓰레기는 쓰레기통에!"));
        array.add(new SocialScale_Situation("네가 키우는 강아지보다 친구가 키우는 강아지가 더 귀여워서 네 강아지는 동물보호소에 버리고 강아지를 새로 샀어", "옳다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1mTCN18EhfH5nFKtzRao9aJQMO9bWheoA", "너가 강아지가 됐다고 상상해봐. 잠깐 화장실에 갔다온다던 주인이 돌아오지 않아. 춥고 배도 고프고 주변엔 처음 보는 강아지들뿐이야. 어떨 것 같니? 강아지도 소중한 생명이고 생명을 키운다는 것은 큰 책임감을 요구하는 일이야."));
        array.add(new SocialScale_Situation("치킨이 먹고 싶은데 용돈을 다 써서 엄마 지갑에서 돈을 몰래 꺼내서 치킨을 사먹었어", "괜찮다", "옳지 않다", 2, "http://drive.google.com/uc?export=view&id=1wJoa0sgbbL6V16L80ezbRE7oY6SM8dTM", "다시 한번 생각해볼래? 엄마 아빠랑 같이 어느 쪽이 정답일지 이야기해보는 것도 좋을 것 같아"));
        
        binding.tvSituation.setText(array.get(SocialScale1.pick.get(SocialScale1.number)).getSituation());
        Glide.with(this).load(array.get(SocialScale1.pick.get(SocialScale1.number)).getPhoto()).error(R.drawable.profile).into(binding.socialImage);

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialScale3.class);
                startActivity(intent);
            }
        });
    }
}
