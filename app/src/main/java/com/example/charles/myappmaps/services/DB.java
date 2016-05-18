package com.example.charles.myappmaps.services;

import android.content.Context;
import android.util.Log;

/**
 * Created by EdivaGt on 18/05/2016.
 * padrão singleton
 */
public class DB {

    private static BaseDado instance;

    public static BaseDado

    getInstance(Context context)
    {
        if ( instance == null  )
        {
            instance = new BaseDado(context);
            Log.i("Banco","intancia ok");
        }
        return instance;
    }
}
