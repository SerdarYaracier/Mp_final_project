package com.example.cteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main_page extends AppCompatActivity {

    CardView home,library,sepet,wishlist,profile,settings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        home=findViewById(R.id.home_cardView);

        sepet=findViewById(R.id.sepet_cardView);







        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_page.this, Market_page.class);
                startActivity(intent);

            }
        });





        sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_page.this, Sepet.class);
                startActivity(intent);

            }
        });










    }
}