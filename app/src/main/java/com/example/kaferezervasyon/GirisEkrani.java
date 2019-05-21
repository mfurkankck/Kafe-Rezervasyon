package com.example.kaferezervasyon;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;


public class GirisEkrani extends AppCompatActivity {
    private static int gosterim_suresi = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(GirisEkrani.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, gosterim_suresi);

    }
}
