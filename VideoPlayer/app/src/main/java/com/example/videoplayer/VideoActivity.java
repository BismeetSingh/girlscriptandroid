package com.example.videoplayer;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme2);
        setContentView(R.layout.activity_video);

        String path = getIntent().getStringExtra("VIDEO_PATH");
        Uri uri = Uri.parse(path);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //DisplayMetrics metrics = new DisplayMetrics();
        VideoView videoView =  findViewById(R.id.videoView);
        //videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1);
        videoView.setVideoURI(uri);
        //getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //videoView.setLayoutParams(new RelativeLayout.LayoutParams(metrics.widthPixels, metrics.heightPixels));
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}

