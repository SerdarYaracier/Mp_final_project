package com.example.cteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

public class Market_page extends AppCompatActivity {

    private static final String TAG="Market_page";

    private DatabaseReference reference;
    private Context mContext = Market_page.this;
    private StorageReference myStoragereference;

    private RecyclerView recyclerView;

    private ArrayList<images> imageList;
    private Adapter adapter;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_page);

        Log.d(TAG, "onCreate: started" );

        recyclerView=findViewById(R.id.market_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        reference= FirebaseDatabase.getInstance().getReference();
        myStoragereference= FirebaseStorage.getInstance().getReference();

        imageList = new ArrayList<>();

        init();







    }

    private void init(){

        clearAll();
        Query query = reference.child("Images");

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