package com.example.charles.myappmaps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charles.myappmaps.Controle.Controle;
import com.example.charles.myappmaps.model.Usuario;
import com.example.charles.myappmaps.services.DB;

public class CadastrarUsuarioActivity extends Activity {

    protected EditText usuario;
    protected EditText senha;
    protected  EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);





        this.usuario = (EditText) findViewById(R.id.edNome );
        this.senha = (EditText) findViewById(R.id.senha );
        this.email = (EditText) findViewById(R.id.email );


        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Controle controle = new Controle();
                Usuario usuario_obj = new Usuario();

                usuario_obj.setCodigo('2');
                usuario_obj.setNome(usuario.getText().toString());
                usuario_obj.setSenha(senha.getText().toString());
                usuario_obj.setEmail(email.getText().toString());

                Toast.makeText(CadastrarUsuarioActivity.this, "Dados do usuario"+usuario_obj.getNome()+" " +
                                ""+usuario_obj.getEmail()+" "+usuario_obj.getSenha(),
                        Toast.LENGTH_LONG).show();

                controle.cadastraUsuario(usuario_obj,CadastrarUsuarioActivity.this);


                //alert("Usuário salvo com Sucesso!");
           }
        });

        Button btVoltar = (Button) findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Navega  para proxima tela
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
