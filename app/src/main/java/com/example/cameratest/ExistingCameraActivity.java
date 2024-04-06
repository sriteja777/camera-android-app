package com.example.cameratest;

import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
//import android.support.v4.app.FragmentActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;




public class ExistingCameraActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private ImageView mImageView;
    private Uri imageUri;
    private boolean tp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_camera);
        mImageView = findViewById(R.id.imageView);
//        getActivity().getContentResolver();
    }

    String imageFilePath;
    Uri fileUri;
    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getFilesDir();
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        imageFilePath = image.getAbsolutePath();
        return image;
    }


    public void takePicture(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Log.d("path", Environment.getExternalStorageDirectory().toString());
//        File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Log.e("error", ex.toString());
            }
            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(this, "com.example.cameratest.fileprovider", photoFile);
//                String realPath = RealPathUtil.getRealPath(this, photoUri);
                fileUri = photoUri;
//                Log.d("real", realPath);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        Log.d("extra", cameraIntent.getExtras().get(MediaStore.EXTRA_OUTPUT).toString());
//                MockActivity.captureIntent(cameraIntent, REQUEST_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
                if (tp) {
                    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
                }
//            } else {
//                Log.e("error", "photo null");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            MockActivity.onMockActivityResult(getContentResolver(), requestCode, resultCode, data);
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            MockActivity.onMockActivityResult(getContentResolver(), requestCode, resultCode, data);
//        } catch (Exception e) {
//            Log.e("er", "mock", e);
//        }
//        if ("getContentResolver" instanceof this) {
//
//        }
         super.onActivityResult(requestCode, resultCode, data);

//        Context context = this;
//        Log.d("context", context.toString());
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (data == null) {
                Log.d("path", "path is null");
                Log.d("path", imageFilePath);

//                this.getApplicationContext();
//                ContentResolver cr = getContentResolver();
//                Bitmap src=BitmapFactory.decodeFile("/sdcard/BrowserStackMockImage.jpg");
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                src.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                byte[] bytes = baos.toByteArray();
//
//                OutputStream outputStream = null;
//                try {
//                    outputStream = cr.openOutputStream(fileUri);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    outputStream.write(bytes);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


                mImageView.setImageBitmap(BitmapFactory.decodeFile(imageFilePath));
                return;
            }
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);

        }
        int a, b,c, d,e, f, g, h, i, j, k;
        a= b= c= d= e= f= g= h= i = j= k=10;
        System.out.println(a+b+c+d+e+f+g+h+i+j+k);

    }

}