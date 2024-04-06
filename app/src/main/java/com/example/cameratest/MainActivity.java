package com.example.cameratest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera2(View view) {
        Intent intent = new Intent(this, Camera2Activity.class);
        startActivity(intent);
    }

    public void openCameraX(View view) {
        Intent intent = new Intent(this, CameraXActivity.class);
        startActivity(intent);
    }

    public void openExistingCamera(View view) {
        Intent intent = new Intent(this, ExistingCameraActivity.class);
        startActivity(intent);
    }
}