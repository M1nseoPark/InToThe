package com.example.intothe.FaceExpand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.MainActivity;
import com.example.intothe.PhotoActivity;
import com.example.intothe.R;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;


public class FaceExpand1 extends AppCompatActivity {
    private static File file; // 촬영한 파일
    private static String json; // 서버에서 받은 json
    public static String rcResult; // 모델 결과

    private static final String POST_URL = "http://3.38.43.78:5000/face_recognition/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:94.0) Gecko/20100101 Firefox/94.0";
    private static String FILE_PATH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_expand_1);

        ImageView btn_photo = (ImageView) findViewById(R.id.btn_photo);
        TextView talk = (TextView) findViewById(R.id.talk);

        MainActivity.photoMode = "FaceExpand";   // PhotoActivity에서 화면 이동을 위해 기록

//        talk.setText(LoginActivity.userName.substring(1,3) + "아(야) 얼굴 확대하기 시간이야.\n카메라 버튼을 누르고 이목구비를 확대해서\n찍어볼래?");
        talk.setText("얼굴 확대하기 시간이야.\n카메라 버튼을 누르고 보여주고 싶은 부분을 확대해서\n찍어볼래?");

        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                startActivity(intent);
            }
        });

        //이미지 파일을 받아서 서버로 결과 요청
        file = PhotoActivity.photoFile;
        FILE_PATH = file.getPath();
        try {
            json = makeRequest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        //결과에서 결과값을 문자열로 get
        try {
            rcResult = getResult(json);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public static String makeRequest() throws IOException, ParseException, ClientProtocolException, org.json.simple.parser.ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.EXTENDED)
                .setBoundary("----WebKitFormBoundaryDeC2E3iWbTv1PwMC")
                .setContentType(ContentType.MULTIPART_FORM_DATA)
                .addBinaryBody("file",new File(FILE_PATH),ContentType.APPLICATION_OCTET_STREAM, FILE_PATH)
                .build();

        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryDeC2E3iWbTv1PwMC");
        httpPost.addHeader("User-Agent", USER_AGENT);
        httpPost.setEntity(entity);

        // 서버로 파일 전송 후 결과 수신
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity result = ((CloseableHttpResponse) response).getEntity();

        // 결과 = json 문자열
        String jsonString = EntityUtils.toString(result, StandardCharsets.UTF_8);

        return jsonString;
    }

    public static String getResult(String jsonString) throws org.json.simple.parser.ParseException {
        // json 문자열의 key 값을 알아오기 위한 jsonObj 객체 생성
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonString);
        JSONObject jsonObj = (JSONObject) obj;

        // key 값을 Set 에 저장
        Set s = jsonObj.keySet();
        Object[] r = s.toArray();

        String result = null;

        if(r[0] == "0")
            result = "Face";
        else if(r[0] == "1")
            result = "Eye";
        else if(r[0] == "2")
            result = "Nose";
        else if(r[0] == "3")
            result = "Mouth";
        else if(r[0] == "4")
            result = "Ear";

        return result;
    }
}
