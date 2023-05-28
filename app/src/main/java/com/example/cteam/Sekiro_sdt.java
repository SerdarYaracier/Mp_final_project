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

public class Sekiro_sdt extends AppCompatActivity {

    ImageView skr1,skr2,skr3,skr4;

    Button sepet,detail;

    VideoView videoView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekiro_sdt);


        skr1=findViewById(R.id.imageView3);
        skr2=findViewById(R.id.imageView5);
        skr3=findViewById(R.id.imageView4);
        skr4=findViewById(R.id.imageView6);
        videoView=findViewById(R.id.videoView);
        sepet=findViewById(R.id.sepet);
        detail=findViewById(R.id.detail__);



        sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Sekiro_sdt.this, Sepet.class);
                startActivity(intent);


            }
        });


        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Sekiro_sdt.this, aciklama_sekiro.class);
                startActivity(intent);





            }
        });




        String videopath = "android.resource://"+getPackageName()+"/"+ R.raw.skr;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



        skr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sekiro_sdt.this, sekiroo1_big_image.class);
                startActivity(intent);
            }
        });

        skr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sekiro_sdt.this, sekiro2_big_iamge.class);
                startActivity(intent);
            }
        });



    }
}