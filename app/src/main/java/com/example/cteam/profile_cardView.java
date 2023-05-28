package com.example.cteam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class profile_cardView extends AppCompatActivity {


    EditText isim,soyisim,kullaniciadi;
    TextView email;
    Button güncelle;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_card_view);


        email=findViewById(R.id.profile_email_txt);
        güncelle=findViewById(R.id.güncelle_btn);

        güncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isim=findViewById(R.id.profile_isim_txt);
                soyisim=findViewById(R.id.profile_soyisim_txt);
                kullaniciadi=findViewById(R.id.profile_username_txt);




            }
        });

    }
}