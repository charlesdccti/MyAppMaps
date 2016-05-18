package com.example.charles.myappmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.charles.myappmaps.model.Academia;
import com.example.charles.myappmaps.services.DB;

import java.util.ArrayList;

public class ListarAcademiasActivity extends AppCompatActivity {

    private ArrayList<Academia> listAcademia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_academias);

         listAcademia= DB.getInstance(this).getAllAcademias();// Pegando lista de academias no banco SQL





        Button btVoltar = (Button) findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Navega  para proxima tela
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
