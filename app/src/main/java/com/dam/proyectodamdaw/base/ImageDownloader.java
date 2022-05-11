package com.dam.proyectodamdaw.base;

import android.content.Context;
import android.widget.ImageView;

import com.dam.proyectodamdaw.activities.SelectCity;
import com.squareup.picasso.Picasso;

public class ImageDownloader {

    public static void DownloadImage(String url, ImageView imageView){
        Picasso.get().load(url).into(imageView);
    }

}
