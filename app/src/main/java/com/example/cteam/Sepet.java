package com.example.cteam;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Sepet extends AppCompatActivity {


    private static final String TAG="Market_page";

    Button buton,satin_al;
    TextView cüzdan,fiyat;

    private EditText oyun_adi;

    private DatabaseReference reference;
    private Context mContext = Sepet.this;
    private StorageReference myStoragereference;

    private RecyclerView recyclerView;

    private ArrayList<images> imageList;
    private Adapter adapter;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);

        Log.d(TAG, "onCreate: started" );

        recyclerView=findViewById(R.id.market_view);
        oyun_adi=findViewById(R.id.oyun_adi);
        buton=findViewById(R.id.button2);
        satin_al=findViewById(R.id.satın_al);
        cüzdan=findViewById(R.id.cüzdan);
        fiyat=findViewById(R.id.fiyat);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        cüzdan.setText("120");


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);


                reference= FirebaseDatabase.getInstance().getReference();
                myStoragereference= FirebaseStorage.getInstance().getReference();

                imageList = new ArrayList<>();

                init();

                fiyat.setText("60");


                satin_al.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                        int a = Integer.valueOf(fiyat.getText().toString());
                        int b = Integer.valueOf(cüzdan.getText().toString());

                        int c = b-a;

                        cüzdan.setText(String.valueOf(c));

                        if(c>=0){



                            Toast.makeText(Sepet.this, "Satın alım başarılı", Toast.LENGTH_SHORT).show();

                        }else {
                            cüzdan.setText("0");

                            Toast.makeText(Sepet.this, "Yetersiz bakiye", Toast.LENGTH_SHORT).show();
                        }


                    }
                });




            }
        });













    }

    private void init(){

        clearAll();
        Query query = reference.child(oyun_adi.getText().toString());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    images images = new images();
                    images.setUrl(snapshot1.child("url").getValue().toString());
                    images.setDescription(snapshot1.child("description").getValue().toString());


                    imageList.add(images);


                }

                adapter = new Adapter(mContext, imageList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void clearAll(){
        if(imageList!= null){
            imageList.clear();
        }
        imageList = new ArrayList<>();


        if(adapter!= null){
            adapter.notifyDataSetChanged();
        }


    }
}