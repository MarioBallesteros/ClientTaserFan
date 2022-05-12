package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.Ciudad;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.activities.preferences.GestionPreferencias;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.model.Model;

public class AddCity extends BaseActivity implements CallInterface,View.OnClickListener {

    private TextView cityName;
    private TextView cityLat;
    private TextView cityLon;
    private TextView cityImage;
    private Button addCiudad;
    private Root root;
    private Ciudad city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_city);

        cityName = findViewById(R.id.cityName);
        cityLat = findViewById(R.id.cityLat);
        cityLon = findViewById(R.id.cityLon);
        cityImage = findViewById(R.id.cityImage);
        addCiudad = findViewById(R.id.buttonAdd);

//        addCiudad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),SelectCity.class);
//                startActivity(intent);
//            }
//        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        showProgress();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        if (root==null){
 //               root= (Root) Connector.getConector().get(Root.class,"forecast?lang="+GestionPreferencias.getInstance().getIdiomas(this)+"&units="+ GestionPreferencias.getInstance().getUnidades(this)+"&lat="+city.getLat()+"&lon="+city.getLon()+"&appid=663b25f4032d78f1fcc93534cfdbc1f7");
        }
    }

    @Override
    public void doInUI() {
        hideProgress();

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,root);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerViewAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       // Root l = Model.getInstance().getList().get(recyclerView.getChildAdapterPosition(view));
        Toast.makeText(this,"Click en ",Toast.LENGTH_SHORT).show();
    }
}