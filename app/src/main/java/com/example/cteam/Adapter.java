package com.example.cteam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final String TAG = "Adapter";
    private Context mContext;
    private ArrayList<images> imageslist;


    public Adapter (Context context, ArrayList<images>imageslist){
        this.mContext= context;
        this.imageslist=imageslist;


    }

     public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView Description;

        TextView price;


         public ViewHolder(@NonNull View itemView) {
             super(itemView);

             imageView=itemView.findViewById(R.id.game_poster);
             Description=itemView.findViewById(R.id.Description);



         }
     }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      holder.Description.setText(imageslist.get(position).getDescription());
        Picasso.get().load(imageslist.get(position).getUrl())
                .into(holder.imageView);

        switch (position){
            case 0:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Resident_evil_2.class);
                        view.getContext().startActivity(intent);

                    }

                });
                break;



            case 1:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(view.getContext(),RDR.class);
                        view.getContext().startActivity(intent);


                    }
                });
                break;

            case 2:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Sekiro_sdt.class);
                        view.getContext().startActivity(intent);

                    }
                });
                break;

            case 3:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),civvv6.class);
                        view.getContext().startActivity(intent);

                    }
                });
                break;

            case 4:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Baldur.class);
                        view.getContext().startActivity(intent);

                    }
                });
                break;

            case 5:
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Dmc5.class);
                        view.getContext().startActivity(intent);


                    }
                });
                break;


        }


    }



    @Override
    public int getItemCount() {
        return imageslist.size();
    }
}
