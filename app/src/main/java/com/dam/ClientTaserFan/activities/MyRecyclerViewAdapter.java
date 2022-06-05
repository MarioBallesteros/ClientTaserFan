package com.dam.ClientTaserFan.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.ClientTaserFan.Parameters;
import com.dam.ClientTaserFan.R;
import com.dam.ClientTaserFan.base.ImageDownloader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;
    private List<Vehiculo> vehiculosList;
    private Context paramcontext;

    public MyRecyclerViewAdapter(Context context, List<Vehiculo> vehiculosList){
        this.vehiculosList = vehiculosList;
        paramcontext = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.simple_element,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Vehiculo vehiculo = vehiculosList.get(position);
        switch (vehiculo.get)
    }

    @Override
    public int getItemCount() {
        return vehiculosList.size();
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView TexttipoLluvia;
        TextView Textdia;
        TextView Texthora;
        TextView Textfecha;
        TextView Texttemp;
        TextView Textmax;
        TextView Textmin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            Texthora = itemView.findViewById(R.id.hora);
            TexttipoLluvia = itemView.findViewById(R.id.tipoLluvia);
            Textdia = itemView.findViewById(R.id.dia);
            Textfecha = itemView.findViewById(R.id.fecha);
            Texttemp = itemView.findViewById(R.id.temp);
            Textmin = itemView.findViewById(R.id.min);
            Textmax = itemView.findViewById(R.id.max);
        }
    }

    public void setOnClickListener(View.OnClickListener clickListener) {
        onClickListener = clickListener;
    }
}
