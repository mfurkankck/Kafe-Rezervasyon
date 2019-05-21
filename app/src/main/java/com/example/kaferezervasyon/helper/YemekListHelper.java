package com.example.kaferezervasyon.helper;

import com.example.kaferezervasyon.R;
import com.example.kaferezervasyon.model.Yemek;

import java.util.ArrayList;

public class YemekListHelper {

    public ArrayList<Yemek> yemekListesiOlustur() {

        ArrayList<Yemek> yemekListesi = new ArrayList<>();

        int[] idler = {1,2,3,4,5,6};

        String[] isimler = {"Karnıyarık","Tavuk Sote","Pilav","Makarna","Yaprak Sarma","İçli Köfte"};

        int[] images = {R.drawable.yemek,
                R.drawable.yemek1,
                R.drawable.yemek2,
                R.drawable.yemek3,
                R.drawable.yemek4,
                R.drawable.yemek5};

        for (int i = 0; i <isimler.length; i ++){
            Yemek gecerliYemek = new Yemek();
            gecerliYemek.setId(idler[i]);
            gecerliYemek.setmIsim(isimler[i]);
            gecerliYemek.setResim(images[i]);

            yemekListesi.add(gecerliYemek);
        }

        return yemekListesi;

    }

}
