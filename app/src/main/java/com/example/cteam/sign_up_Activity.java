package com.example.cteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up_Activity extends AppCompatActivity {

    Button sign_up_btn;
    EditText email,password,password_again;
    private FirebaseAuth mAuth;

    private  String Email,sifre;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign_up_btn=findViewById(R.id.sign_up_btn);
        email=findViewById(R.id.email_txt);
        password=findViewById(R.id.password_txt);
        password_again=findViewById(R.id.password_again_txt);
        mAuth= FirebaseAuth.getInstance();

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    Email=email.getText().toString();
                    sifre=password.getText().toString();

                    if (!TextUtils.isEmpty(sifre)&& !TextUtils.isEmpty(Email)) {

                        if(password_again.getText().toString().length()==6){

                            mAuth.createUserWithEmailAndPassword(Email, sifre)
                                    .addOnCompleteListener(sign_up_Activity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            Toast.makeText(sign_up_Activity.this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();
                                        }
                                    });



                        }else Toast.makeText(sign_up_Activity.this, "Şifreler uyumsuz", Toast.LENGTH_SHORT).show();



                    }else Toast.makeText(sign_up_Activity.this, "Hata", Toast.LENGTH_SHORT).show();




                    //Toast.makeText(MainActivity.this, "çalışıyom", Toast.LENGTH_SHORT).show();






            }
        });



    }
}