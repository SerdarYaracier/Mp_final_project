package com.example.cteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button kayit_btn,giris_btn;
    EditText email_txt, password_txt;

    private FirebaseAuth mAuth;
    private  String adi,Email,sifre;



    //@SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giris_btn=findViewById(R.id.btn_giris);
        kayit_btn=findViewById(R.id.btn_kayit);
        email_txt=findViewById(R.id.email_txt);
        password_txt=findViewById(R.id.password_txt);
        mAuth=FirebaseAuth.getInstance();

        kayit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),sign_up_Activity.class);
                startActivity(intent);



                //Toast.makeText(MainActivity.this, "çalışıyom", Toast.LENGTH_SHORT).show();
            }
        });

        giris_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Email=email_txt.getText().toString();
                sifre=password_txt.getText().toString();

                if (!TextUtils.isEmpty(sifre)&& !TextUtils.isEmpty(Email)){
                    mAuth.signInWithEmailAndPassword(Email,sifre)
                            .addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(MainActivity.this, "Giris yapıldı", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,Main_page.class);
                                    startActivity(intent);
                                }
                            });

                    mAuth.signInWithEmailAndPassword(Email,sifre)
                            .addOnFailureListener(MainActivity.this, new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, "Başarısız giris", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else Toast.makeText(MainActivity.this, "Bilgileri boş bırakmayınız", Toast.LENGTH_SHORT).show();




            }
        });




    }
}