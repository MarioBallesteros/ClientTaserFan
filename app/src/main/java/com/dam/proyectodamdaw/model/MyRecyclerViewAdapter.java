package com.dam.proyectodamdaw.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;
    private Root root;

    public MyRecyclerViewAdapter(Context context, Root root){
        this.root=root;
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
        Date date = new Date((long) root.list.get(position).dt*1000);

        holder.Texthora.setText(""+ new SimpleDateFormat("HH:mm").format(date));
        holder.Textdia.setText(""+ new SimpleDateFormat("EEEE",new Locale("es","ES")).format(date));
        holder.Textfecha.setText(""+ new SimpleDateFormat("dd/MM/YYYY").format(date));
        holder.TexttipoLluvia.setText(""+ new SimpleDateFormat("EEEE").format(date));
        holder.Textmax.setText("" );
    }

    @Override
    public int getItemCount() {
        return root.list.size();
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

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
