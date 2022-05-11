package com.dam.proyectodamdaw.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        List l = root.list.get(position);
        Date date = new Date((long) l.dt*1000);
        String url = Parameters.URL_ICON_PRE+l.weather.get(0).icon+Parameters.URL_ICON_POST;

        ImageDownloader.DownloadImage(url,holder.image);

        holder.Texthora.setText(""+ new SimpleDateFormat("HH:mm").format(date));
        holder.Textdia.setText(""+ new SimpleDateFormat("EEEE",new Locale("es","ES")).format(date));
        holder.Textfecha.setText(""+ new SimpleDateFormat("dd/MM/YYYY").format(date));
        holder.TexttipoLluvia.setText(""+ l.weather.get(0).description);
        holder.Texttemp.setText(""+String.format("%.2f", (l.main.temp)/10)+"°C");
        holder.Textmax.setText(""+String.format("%.2f", (l.main.temp_max)/10)+"°C");
        holder.Textmin.setText(""+String.format("%.2f", (l.main.temp_min)/10)+"°C");

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
