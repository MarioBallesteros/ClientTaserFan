package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.proyectodamdaw.Ciudad;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;

import com.dam.proyectodamdaw.api.Result;

public class AddCity extends BaseActivity implements CallInterface {

    private EditText cityName;
    private EditText cityLat;
    private EditText cityLon;
    private EditText cityImage;
    private Button addCiudad;
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_city);

        cityName = findViewById(R.id.cityNametxt);
        cityLat = findViewById(R.id.cityLattxt);
        cityLon = findViewById(R.id.cityLontxt);
        cityImage = findViewById(R.id.cityImagetxt);
        addCiudad = findViewById(R.id.buttonCreate);

        addCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                executeCall(AddCity.this);
                intent.putExtra("cityName",cityName.getText().toString());
                intent.putExtra("cityLat",cityLat.getText().toString());
                intent.putExtra("cityLon",cityLon.getText().toString());
                intent.putExtra("cityImg",cityImage.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    @Override
    public void doInBackground() {
       Connector.getConector().CityPost(Ciudad.class,new Ciudad(cityName.getText().toString(),Double.parseDouble(cityLat.getText().toString()),Double.parseDouble(cityLon.getText().toString()),cityImage.getText().toString()),"/addCiudad");
        }


    @Override
    public void doInUI() {
        if (result instanceof Result.Success){
            Toast.makeText(this,"ciudad creada",Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this,"Ha habido un error",Toast.LENGTH_SHORT).show();
        }
    }
