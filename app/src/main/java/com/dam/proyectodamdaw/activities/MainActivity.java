package com.dam.proyectodamdaw.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.model.Model;
import com.dam.proyectodamdaw.model.MyRecyclerViewAdapter;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.model.Root;

import java.util.List;

public class MainActivity extends BaseActivity implements CallInterface,View.OnClickListener {

    private RecyclerView recyclerView;
    private Root root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
    }

    @Override
    protected void onResume() {
        super.onResume();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        showProgress();
        root = (Root) Connector.getConector().get(Root.class,"forecast?lat=39.5891534&lon=-0.5432784&lang=es&appid=663b25f4032d78f1fcc93534cfdbc1f7");
    }

    @Override
    public void doInUI() {
        hideProgress();

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,root);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerViewAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Root l = Model.getInstance().getList().get(recyclerView.getChildAdapterPosition(view));
        Toast.makeText(this,"Click en ",Toast.LENGTH_SHORT).show();
    }
}