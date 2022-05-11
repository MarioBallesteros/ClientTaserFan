package com.dam.proyectodamdaw.model;

import com.dam.proyectodamdaw.activities.Root;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static Model model;
    private List<Root> list;

    private Model(){
        list = new ArrayList<>();

        list.add(new Root());

    }
    public static Model getInstance(){
        if (model==null)
            model = new Model();

        return model;
    }

    public List<Root> getList() {
        return list;
    }
}
