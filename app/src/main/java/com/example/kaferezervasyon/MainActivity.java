package com.example.kaferezervasyon;



import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toolbar;

import com.example.kaferezervasyon.model.Rezervasyon;
import com.google.gson.Gson;


import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    Button tarihsec, baslangicsaati, bitissaati,ileri1;
    EditText  no1, ad1, mail1;
    TextView tarih,baslangicsaati1,bitissaati1;
    private Rezervasyon rezervasyon;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tarihsec = (Button) findViewById(R.id.tarih);
        baslangicsaati = (Button) findViewById(R.id.saat);
        bitissaati = (Button) findViewById(R.id.saat2);
        tarih = (TextView) findViewById(R.id.tarih1);
        baslangicsaati1 = (TextView) findViewById(R.id.saat1);
        bitissaati1 = (TextView) findViewById(R.id.saat3);
        ileri1 = (Button) findViewById(R.id.ileri);
        ad1 = (EditText) findViewById(R.id.ad);
        no1 = (EditText) findViewById(R.id.no);
        mail1 = (EditText) findViewById(R.id.mail);





        tarihsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar takvim = Calendar.getInstance();
                int yil = takvim.get(Calendar.YEAR);
                int ay = takvim.get(Calendar.MONTH);
                int gun = takvim.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month += 1;
                        tarih.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, yil, ay, gun);
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
            }
        });
        baslangicsaati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar saats = Calendar.getInstance();
                int hour = saats.get(Calendar.HOUR);
                int dakika = saats.get(Calendar.MINUTE);
                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        baslangicsaati1.setText(hourOfDay + ":" + minute);

                    }
                }, hour, dakika, true);
                tpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", tpd);
                tpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", tpd);
                tpd.show();
            }
        });
        bitissaati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar saats = Calendar.getInstance();
                int hour1 = saats.get(Calendar.HOUR);
                int dakika1 = saats.get(Calendar.MINUTE);
                TimePickerDialog tpd1 = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay1, int minute1) {
                        bitissaati1.setText(hourOfDay1 + ":" + minute1);

                    }
                }, hour1, dakika1, true);
                tpd1.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", tpd1);
                tpd1.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", tpd1);
                tpd1.show();
            }
        });
        this.rezervasyon = new Rezervasyon();


        ileri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rezervasyon.setIsim(ad1.getText().toString());
                rezervasyon.setTarih(tarih.getText().toString());
                rezervasyon.setBassaati(baslangicsaati1.getText().toString());
                rezervasyon.setBitsaati(bitissaati1.getText().toString());
                rezervasyon.setMail(mail1.getText().toString());
                rezervasyon.setTelefon(no1.getText().toString());
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(rezervasyon);
                editor.putString("rezervasyon",json);
                editor.apply();
                Intent i = new Intent(MainActivity.this,Menusecimi.class);
                startActivity(i);
            }
        });

    }



    }


















