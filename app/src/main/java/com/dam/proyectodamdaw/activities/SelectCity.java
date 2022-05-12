package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


import androidx.annotation.Nullable;

import com.dam.proyectodamdaw.Ciudad;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

public class SelectCity extends BaseActivity implements CallInterface {

    private Ciudad ciudad;
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;

    private Button button;
    private ImageView imgCity;
    private ArrayList citiesList;
    private static List<Ciudad> ciudades;
    private Button Addcity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_city);
        imgCity=findViewById(R.id.imgCity);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.buttonCity);
        Addcity = findViewById(R.id.buttonAdd);






        Addcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AddCity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("selected",ciudad);
                startActivity(intent);
            }
        });
            executeCall(this);


    }


    @Override
    public void doInBackground() {
        ciudades = Connector.getConector().getAsListWithAllPath(Ciudad.class,"http://10.11.19.6:4567/cities");
    }

    @Override
    public void doInUI() {
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ciudades);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ImageDownloader.downloadImage(getApplicationContext(),ciudades.get(i).getImg(),imgCity, ImageView.ScaleType.CENTER_CROP,R.mipmap.ic_launcher);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
