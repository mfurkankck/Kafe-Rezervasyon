package com.example.kaferezervasyon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kaferezervasyon.model.Rezervasyon;
import com.example.kaferezervasyon.model.Yemek;
import com.google.gson.Gson;

import static com.example.kaferezervasyon.model.Rezervasyon.*;

public class kisibilgileri extends AppCompatActivity {
    TextView mail, telefon,  saat1, saat2, tarih , isim , menu , masa, GidecekMail;

    Button gönder;
    private Rezervasyon rezervasyon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisibilgileri);
        tarih = (TextView) findViewById(R.id.date);
        mail = (TextView) findViewById(R.id.email);
        isim = (TextView) findViewById(R.id.name);
        menu = (TextView) findViewById(R.id.menu);
        masa = (TextView) findViewById(R.id.masa);
        telefon = (TextView) findViewById(R.id.phone);
        saat1 =  (TextView) findViewById(R.id.hour);
        gönder = (Button) findViewById(R.id.gönder);
        GidecekMail = (EditText) findViewById(R.id.MailGönder);



        this.rezervasyon = new Rezervasyon();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(kisibilgileri.this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("rezervasyon", "");
        Rezervasyon rezervasyon1 = gson.fromJson(json, Rezervasyon.class);
        tarih.setText(rezervasyon1.getTarih());
        mail.setText(rezervasyon1.getMail());
        telefon.setText(rezervasyon1.getTelefon());
        saat1.setText(rezervasyon1.getBassaati()+ "/" + rezervasyon1.getBitsaati());
        isim.setText(rezervasyon1.getIsim());
        masa.setText(rezervasyon1.getMasa());




        gönder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{GidecekMail.getText().toString()});


                it.putExtra(Intent.EXTRA_TEXT,tarih.getText() + "tarihinde , " + saat1.getText() + " saatleri arasında ," +isim.getText() + "," + telefon.getText() + "," + mail.getText() + "bilgilerine ait kişi tarafından"
                + masa.getText() + " rezervasyon etmiştir.");
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,""));
            }
        });




    }




}


