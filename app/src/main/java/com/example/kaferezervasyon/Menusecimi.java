package com.example.kaferezervasyon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.kaferezervasyon.helper.YemekListHelper;
import com.example.kaferezervasyon.model.Rezervasyon;
import com.google.gson.Gson;

public class Menusecimi extends AppCompatActivity {

    Button button;

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.yemek, R.drawable.yemek1, R.drawable.yemek2, R.drawable.yemek3, R.drawable.yemek4, R.drawable.yemek5};

    private RecyclerAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;
    private Rezervasyon mRezervasyon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menusecimi);
        YemekListHelper yemekListHelper = new YemekListHelper();

        button = (Button) findViewById(R.id.button1);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(Menusecimi.this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(yemekListHelper.yemekListesiOlustur());
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Menusecimi.this);
                String stRezervasyon = sharedPreferences.getString("rezervasyon", null);

                if (stRezervasyon != null)
                    mRezervasyon = new Gson().fromJson(stRezervasyon, Rezervasyon.class);

                if (mRezervasyon == null) {
                    mRezervasyon = new Rezervasyon();
                }

                mRezervasyon.setYemekSayisi(adapter.secilenYemekleriGetir());



                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(mRezervasyon);
                editor.putString("rezervasyon", json);
                editor.apply();

                Intent a = new Intent(Menusecimi.this, MasaSecimi.class);
                startActivity(a);
            }
        });


    }

}
