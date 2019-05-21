package com.example.kaferezervasyon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaferezervasyon.model.Rezervasyon;
import com.google.gson.Gson;

public class MasaSecimi extends AppCompatActivity {
    Button MasaSec,SonrakiSayfa;
    TextView SecilenMasa;
    RadioGroup radioGroup;
    RadioButton radioButton;



    private ImageView imageView;
    private Rezervasyon rezervasyon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_secimi);
        radioGroup = (RadioGroup) findViewById(R.id.MasaSecimi);
        SecilenMasa = (TextView) findViewById(R.id.SecilenMasa);
        MasaSec = (Button) findViewById(R.id.button);
        SonrakiSayfa = (Button) findViewById(R.id.ileri);

        MasaSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton= (RadioButton) findViewById(selectedId);
                SecilenMasa.setText(radioButton.getText());
            }
        });

        SonrakiSayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MasaSecimi.this);
                String stRezervasyon = sharedPreferences.getString("rezervasyon", null);

                if (stRezervasyon != null)
                    rezervasyon = new Gson().fromJson(stRezervasyon, Rezervasyon.class);

                if (rezervasyon == null) {
                    rezervasyon = new Rezervasyon();
                }

                rezervasyon.setMasa(SecilenMasa.getText().toString());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(rezervasyon);
                editor.putString("rezervasyon",json);
                editor.apply();

                Intent i = new Intent(MasaSecimi.this,kisibilgileri.class);
                startActivity(i);

            }
        });



    }


    }


