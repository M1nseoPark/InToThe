package com.example.intothe.ChangeFace1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ChangeFace11 extends AppCompatActivity {

    public static String stResult; // 선택 결과
    public static File file; // 촬영한 파일
    public static String json; // 서버에서 받은 json
    public static String rcResult; // 모델 결과

    //URL IP 주소는 서버 열때마다 바뀌므로 수정 필요
    private static final String POST_URL = "http://3.35.67.156:5000/face_sentiment/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:94.0) Gecko/20100101 Firefox/94.0";
    public static String FILE_PATH;

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
    }

    public static String makeRequest() throws IOException, ParseException, ClientProtocolException, org.json.simple.parser.ParseException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpEntity entity = MultipartEntityBuilder.create()
//                .setMode(HttpMultipartMode.EXTENDED)
//                .setBoundary("----WebKitFormBoundaryDeC2E3iWbTv1PwMC")
//                .setContentType(ContentType.MULTIPART_FORM_DATA)
//                .addBinaryBody("file", new File(FILE_PATH), ContentType.APPLICATION_OCTET_STREAM, FILE_PATH)
//                .build();
//
//        HttpPost httpPost = new HttpPost(POST_URL);
//        httpPost.addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryDeC2E3iWbTv1PwMC");
//        httpPost.addHeader("User-Agent", USER_AGENT);
//        httpPost.setEntity(entity);
//
//        // 서버로 파일 전송 후 결과 수신
//        HttpResponse response = httpClient.execute(httpPost);
//        HttpEntity result = ((CloseableHttpResponse) response).getEntity();
//
//        // 결과 = json 문자열
//        String jsonString = EntityUtils.toString(result, StandardCharsets.UTF_8);
//        return jsonString;

        return multipartRequest(POST_URL, new HashMap<>(), FILE_PATH, "file", "image/jpeg");
    }

    public static String getResult(String jsonString) throws org.json.simple.parser.ParseException {
        Log.d("FaceExpand1", jsonString);

        try {
            org.json.JSONObject object = new JSONObject(jsonString);
            if (object.has("0"))
                return "Face";
            else if (object.has("1"))
                return "Eye";
            else if (object.has("2"))
                return "Nose";
            else if (object.has("3"))
                return "Mouth";
            else if (object.has("4"))
                return "Ear";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String multipartRequest(String urlTo, Map<String, String> parmas, String filepath, String filefield, String fileMimeType) {
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        InputStream inputStream = null;

        String twoHyphens = "--";
        String boundary = "*****" + Long.toString(System.currentTimeMillis()) + "*****";
        String lineEnd = "\r\n";

        String result = "";

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;

        String[] q = filepath.split("/");
        int idx = q.length - 1;

        try {
            File file = new File(filepath);
            FileInputStream fileInputStream = new FileInputStream(file);

            URL url = new URL(urlTo);
            connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream.writeBytes("Content-Disposition: form-data; name=\"" + filefield + "\"; filename=\"" + q[idx] + "\"" + lineEnd);
            outputStream.writeBytes("Content-Type: " + fileMimeType + lineEnd);
            outputStream.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);

            outputStream.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            outputStream.writeBytes(lineEnd);

            // Upload POST Data
            Iterator<String> keys = parmas.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = parmas.get(key);

                outputStream.writeBytes(twoHyphens + boundary + lineEnd);
                outputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd);
                outputStream.writeBytes("Content-Type: text/plain" + lineEnd);
                outputStream.writeBytes(lineEnd);
                outputStream.writeBytes(value);
                outputStream.writeBytes(lineEnd);
            }

            outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);


            if (200 != connection.getResponseCode()) {
                throw new Exception("Failed to upload code:" + connection.getResponseCode() + " " + connection.getResponseMessage());
            }

            inputStream = connection.getInputStream();

            result = convertStreamToString(inputStream);

            fileInputStream.close();
            inputStream.close();
            outputStream.flush();
            outputStream.close();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
