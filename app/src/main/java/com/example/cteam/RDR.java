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

public class RDR extends AppCompatActivity {

    ImageView rdr1,rdr2,rdr3,rdr4;
    VideoView videoView;

    Button sepet,detail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdr);


        rdr1=findViewById(R.id.imageView3);
        rdr2=findViewById(R.id.imageView5);
        rdr3=findViewById(R.id.imageView4);
        rdr4=findViewById(R.id.imageView6);
        videoView=findViewById(R.id.videoView);
        sepet=findViewById(R.id.sepet);
        detail=findViewById(R.id.detail__);

        sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RDR.this, Sepet.class);
                startActivity(intent);


            }
        });


        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(RDR.this, aciklama_rdr2.class);
                startActivity(intent);





            }
        });




        String videopath = "android.resource://"+getPackageName()+"/"+ R.raw.rdr2;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        rdr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RDR.this, rdr1_big_image.class);
                startActivity(intent);
            }
        });

        rdr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RDR.this, rdr2_big_image.class);
                startActivity(intent);
            }
        });



    }
}