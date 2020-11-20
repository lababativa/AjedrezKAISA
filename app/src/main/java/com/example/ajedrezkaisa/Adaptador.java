package com.example.ajedrezkaisa;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class Adaptador extends ArrayAdapter<Users> {
    Context context;
    List<Users>arrayalistaUsers;
    public Adaptador(@NonNull Context context, List<Users>arrayalistaUsers){
        super(context,R.layout.activity_perfil,arrayalistaUsers);

        this.context=context;
        this.arrayalistaUsers=arrayalistaUsers;
    }
}
