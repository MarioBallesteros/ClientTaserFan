package com.dam.ClientTaserFan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.dam.ClientTaserFan.activities.MyRecyclerViewAdapter;
import com.dam.ClientTaserFan.api.Connector;
import com.dam.ClientTaserFan.base.BaseActivity;
import com.dam.ClientTaserFan.base.CallInterface;
import com.dam.proyectodamdaw.R;

import java.util.LinkedList;
import java.util.List;

public class RecyclerVehicle extends BaseActivity implements View.OnClickListener, CallInterface {
    private List<Vehiculo> vehiculos;
    private RecyclerView recyclerView;
    Button addVehicle;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        addVehicle=findViewById(R.id.addVehicle);
        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerVehicle.this,MainVehicle.class);
                startActivity(intent);
            }
        });
        executeCall(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void doInBackground() {
        vehiculos = new LinkedList<>(Connector.getConector().getAsList(Vehiculo.class,"/all"));
    }

    @Override
    public void doInUI() {
        recyclerView = findViewById(R.id.recycler);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this,vehiculos);
    }
}
