package com.example.kaferezervasyon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kaferezervasyon.model.Yemek;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
    private ArrayList<Yemek> yemekler;
    private HashMap<Integer, Integer> secilenYemekler = new HashMap<>();

    public RecyclerAdapter(ArrayList<Yemek> yemekListesi) {
        this.yemekler = yemekListesi;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);


        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {

        final Yemek gecerliYemek = yemekler.get(position);

        holder.Album.setImageResource(gecerliYemek.getResim());
        holder.YemekIsmi.setText(gecerliYemek.getmIsim());

        holder.Sayi.setText("0");
        holder.Arti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gecerliSayi = (String) holder.Sayi.getText().toString();
                int number = Integer.valueOf(gecerliSayi) + 1;
                holder.Sayi.setText("" + number);
                secilenYemekler.put(gecerliYemek.getId(), number);
            }
        });

        holder.Eksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gecerlisayi = (String) holder.Sayi.getText().toString();
                int number = Integer.valueOf(gecerlisayi);
                if (number != 0) {
                    number = number - 1;
                    holder.Sayi.setText("" + number);

                    if (number != 0) {
                        secilenYemekler.put(gecerliYemek.getId(), number);
                    } else
                        secilenYemekler.remove(gecerliYemek.getId());

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return yemekler.size();
    }

    public HashMap<Integer, Integer> secilenYemekleriGetir(){
        return secilenYemekler;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView Album;
        TextView Sayi, YemekIsmi;
        Button Arti, Eksi;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            Sayi = itemView.findViewById(R.id.sayi);
            Arti = itemView.findViewById(R.id.arti);
            Eksi = itemView.findViewById(R.id.eksi);
            YemekIsmi = itemView.findViewById(R.id.tv_yemek_ismi);
        }
    }
}
