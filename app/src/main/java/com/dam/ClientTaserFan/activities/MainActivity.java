package com.dam.ClientTaserFan.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.ClientTaserFan.Ciudad;
import com.dam.ClientTaserFan.activities.preferences.GestionPreferencias;
import com.dam.ClientTaserFan.api.Connector;
import com.dam.ClientTaserFan.base.BaseActivity;
import com.dam.ClientTaserFan.base.CallInterface;
import com.dam.ClientTaserFan.R;

public class MainActivity extends BaseActivity implements CallInterface,View.OnClickListener {

    private RecyclerView recyclerView;
    private Root root;
    private TextView actualCity;
    private Ciudad city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        actualCity = findViewById(R.id.selectedCity);
        city = (Ciudad) getIntent().getExtras().getSerializable("selected");

        actualCity.setText(city.getName());
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
                root= (Root) Connector.getConector().get(Root.class,"forecast?lang="+GestionPreferencias.getInstance().getIdiomas(this)+"&units="+ GestionPreferencias.getInstance().getUnidades(this)+"&lat="+city.getLat()+"&lon="+city.getLon()+"&appid=663b25f4032d78f1fcc93534cfdbc1f7");
        }
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