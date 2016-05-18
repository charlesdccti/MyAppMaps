package com.example.charles.myappmaps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btLocalizarAcademiasMapa = (Button) findViewById(R.id.btLocalizarAcademiasMapa);
        btLocalizarAcademiasMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Navega  para proxima tela
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });


        Button btListarAcademias = (Button) findViewById(R.id.btListarAcademias);
        btListarAcademias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Navega  para proxima tela

                Intent intent = new Intent(getApplicationContext(), ListarAcademiasActivity.class );
                startActivity(intent);
            }
        });


        Button btSair = (Button) findViewById(R.id.btSair);
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
            }
        });
    }
}
