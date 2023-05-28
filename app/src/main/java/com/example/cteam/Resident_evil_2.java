package com.example.cteam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Resident_evil_2 extends AppCompatActivity {

    ImageView re1,re2,re3,re4;
    Button detail,sepet;
    VideoView videoView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_evil2);

        re1=findViewById(R.id.imageView3);
        re2=findViewById(R.id.imageView5);
        re3=findViewById(R.id.imageView4);
        re4=findViewById(R.id.imageView6);
        videoView=findViewById(R.id.videoView);
        sepet=findViewById(R.id.sepete_ekle);
        detail=findViewById(R.id.detail__);

        String videopath = "android.resource://"+getPackageName()+"/"+ R.raw.re2;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resident_evil_2.this, Sepet.class);
                startActivity(intent);
            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Resident_evil_2.this, Aciklama_re2.class);
               startActivity(intent);



            }
        });









        re1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resident_evil_2.this, re1_big_image.class);
                startActivity(intent);
            }
        });

        re2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resident_evil_2.this, re2_big_image.class);
                startActivity(intent);
            }
        });

;



    }
}