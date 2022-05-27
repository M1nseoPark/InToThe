package com.example.intothe.SpeakFeeling;

import static android.os.SystemClock.sleep;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.intothe.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SpeakFeeling2 extends AppCompatActivity {

    static RequestQueue requestQueue;
    public static String rcResult;   // 모델 인식 결과
    String stStory;   // 사용자 입력 String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_feeling_2);

        TextView talk = (TextView) findViewById(R.id.talk);
        EditText etStory = (EditText) findViewById(R.id.etStory);
        Button button = (Button) findViewById(R.id.next);

        talk.setText(Roulette.stResult + "가(이) 나왔네!\n너는 언제 " + Roulette.stResult + "을(를) 느껴봤어?");

        // 다음 화면으로 이동
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etStory.length() == 0) {
                    Toast.makeText(getApplicationContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    stStory = etStory.getText().toString();
                    makeRequest();
                    sleep(1000);
//                    Roulette.report += "입력: " + etStory + "\n";
                    Intent intent = new Intent(getApplicationContext(), SpeakFeeling3.class);
                    startActivity(intent);
                }

            }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());  // 요청 큐 만들기
        }
    }


    public void makeRequest() {
        String url = "http://3.38.43.78:5000/text_sentiment/?text=" + stStory;
        Log.v("test", url);

//      요청 객체 만들기 (요청방식, 웹사이트 주소, 응답받을 리스너 객체, 에러 발생시 호출될 리스너 객체)
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답-> ", response);

                        pressResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("에러-> ", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };
        request.setShouldCache(false);   // 이전 응답 결과를 사용하지 않겠다면
        requestQueue.add(request);   // 요청 객체를 큐에 넣어줌
        Log.v("requestQueue", "요청 보냄");
    }

    public void pressResponse(String response) {
        rcResult = response;
        Log.v("test", rcResult);
    }
}
