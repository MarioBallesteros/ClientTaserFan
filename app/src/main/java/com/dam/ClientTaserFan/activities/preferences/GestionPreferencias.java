package com.dam.ClientTaserFan.activities.preferences;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dam.ClientTaserFan.R;


public class GestionPreferencias {

    private SharedPreferences pref;
    private static GestionPreferencias gestionPreferencias;

    private GestionPreferencias(){

    }

    public static GestionPreferencias getInstance(){
        if(gestionPreferencias==null)
            gestionPreferencias = new GestionPreferencias();
        return gestionPreferencias;
    }

    private void inicializa(Context context) {
        if (pref == null)
            pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getUnidades(Context context){
        inicializa(context);
        return pref.getString("unidades","standard");
    }

    public String getIdiomas(Context context){
        inicializa(context);
        return pref.getString("idioma","es");
    }

    public boolean getCheckBoxPreference(Context context){
        inicializa(context);
        return pref.getBoolean("checkBoxPreferenceKey",false);
    }

}