package com.example.intothe;

import static com.example.intothe.MainActivity.photoMode;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.example.intothe.ChangeFace1.ChangeFace12;
import com.example.intothe.FaceExpand.FaceExpand1;
import com.example.intothe.FaceExpand.FaceExpand2;

import org.apache.hc.core5.http.ParseException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoActivity extends AppCompatActivity {
    final private static String TAG = "CAMERA";
    Button btn_photo;
    ImageView iv_photo;
    final static int TAKE_PICTURE = 1;

    public static File photoFile = null;

    // 경로 변수와 요청변수 생성
    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO = 1;

    private Handler uiHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        iv_photo = findViewById(R.id.iv_photo);
        btn_photo = findViewById(R.id.btn_photo);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "권한 설정 완료");
            } else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(PhotoActivity.this, new String[]{
                        android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }

        btn_photo.setEnabled(false);
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photoMode.equals("FaceExpand")) {
                    Intent intent = new Intent(getApplicationContext(), FaceExpand2.class);
                    startActivity(intent);
                } else if (photoMode.equals("ChangeFace")) {
                    Intent intent = new Intent(getApplicationContext(), ChangeFace12.class);
                    startActivity(intent);
                }
            }
        });

        uiHandler = new Handler(Looper.getMainLooper());

        dispatchTakePictureIntent();
    }

    // 권한 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
        }
    }

    // 카메라로 촬영한 사진의 썸네일을 가져와 이미지뷰에 띄워줌
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == RESULT_OK) {
                    File file = new File(mCurrentPhotoPath);
                    Bitmap bitmap = null;
                    ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(), Uri.fromFile(file));
                    try {
                        bitmap = ImageDecoder.decodeBitmap(source);
                        if (bitmap != null) {
                            iv_photo.setImageBitmap(bitmap);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                    if (bitmap != null) {
                        iv_photo.setImageBitmap(bitmap);

                        FaceExpand1.file = PhotoActivity.photoFile;
                        FaceExpand1.FILE_PATH = file.getPath();

                        new Thread(() -> {
                            //이미지 파일을 받아서 서버로 결과 요청
                            try {
                                FaceExpand1.json = FaceExpand1.makeRequest();

                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (ParseException e) {
                                e.printStackTrace();
                            } catch (org.json.simple.parser.ParseException e) {
                                e.printStackTrace();
                            }

                            //결과에서 결과값을 문자열로 get
                            try {
                                FaceExpand1.rcResult = FaceExpand1.getResult(FaceExpand1.json);

                                uiHandler.post(() -> {
                                    if (FaceExpand1.rcResult == null) {
                                        dispatchTakePictureIntent();

                                    } else {
                                        btn_photo.setEnabled(true);
                                    }
                                });

                            } catch (org.json.simple.parser.ParseException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }
                }
                break;
        }
    }

    // 사진 촬영 후 썸네일만 띄워줌. 이미지를 파일로 저장해야 함
    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    // 카메라 인텐트 실행하는 부분
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.intothe.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
}




