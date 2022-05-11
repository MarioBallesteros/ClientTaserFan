package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectodamdaw.Ciudad;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.util.ArrayList;
public class SelectCity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Ciudad ciudad;
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;

    private Button button;
    private ImageView imgCity;
    private ArrayList citiesList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_city);
        imgCity=findViewById(R.id.imgCity);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.buttonCity);

        citiesList= new ArrayList<City>();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,citiesList);
        spinner.setAdapter(arrayAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("selected",ciudad);
                startActivity(intent);
            }
        });

        citiesList.add(new Ciudad("Valencia",39.46975f,-0.37739f,"https://cd1.taquilla.com/data/images/t/83/ciudad-de-las-artes-y-las-ciencias__330x275.jpg"));
        citiesList.add(new Ciudad("Roma",45.5838300f,45.5838300f,"https://www.lavanguardia.com/files/image_948_465/uploads/2017/05/15/5fa3c5d7ef234.jpeg"));
        citiesList.add(new Ciudad("Paris",48.85341f,2.3488f,"https://www.eliberico.com/wp-content/uploads/2021/09/torre-eiffel-francia.jpg"));
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ciudad=(Ciudad)adapterView.getSelectedItem();
        ImageDownloader.DownloadImage(ciudad.getImg(),imgCity);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
