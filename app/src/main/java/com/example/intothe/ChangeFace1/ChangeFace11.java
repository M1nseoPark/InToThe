package com.example.intothe.ChangeFace1;

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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ChangeFace11 extends AppCompatActivity {

    public static String stResult; // 선택 결과
    private static File file; // 촬영한 파일
    private static String json; // 서버에서 받은 json
    public static String rcResult; // 모델 결과

    //URL IP 주소는 서버 열때마다 바뀌므로 수정 필요
    private static final String POST_URL = "http://3.38.43.78:5000/face_sentiment/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:94.0) Gecko/20100101 Firefox/94.0";
    private static String FILE_PATH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_11);

        MainActivity.photoMode = "ChangeFace";   // PhotoActivity에서 화면 이동을 위해 기록
        TextView feeling = (TextView) findViewById(R.id.feeling);

        String[] FeelList = {"기쁨", "당황", "분노", "불안", "상처", "슬픔", "중립"};
        Random random = new Random();
        int pick = random.nextInt(FeelList.length - 1);

        stResult = FeelList[pick];
        feeling.setText(stResult);

        ImageView btn_photo = (ImageView) findViewById(R.id.btn_photo);
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
        }
    }

    public static String makeRequest() throws IOException, ParseException, ClientProtocolException {
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

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity result = ((CloseableHttpResponse) response).getEntity();

        String result_text = EntityUtils.toString(result, String.valueOf(StandardCharsets.UTF_8));

        System.out.println(result);
        System.out.println(result_text);

        //httpClient.close();
        return result_text;
    }

    public static void getResult() throws JSONException {
        String result_text = "{\n" +
                "  \"0\": [\n" +
                "    \"0.926131\"\n" +
                "  ]\n" +
                "}\n";
        JSONObject jObject = new JSONObject(result_text);
        jObject.keys();
    }
}
