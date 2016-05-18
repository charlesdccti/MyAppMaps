package com.example.charles.myappmaps.Controle;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.example.charles.myappmaps.model.Academia;
import com.example.charles.myappmaps.model.Usuario;
import com.example.charles.myappmaps.services.DB;
import com.example.charles.myappmaps.util.SQL;

/**
 * Created by EdivaGt on 18/05/2016.
 */
public class Controle {

    Usuario usuario;
    Academia academia;


 //controle para cadastro de usuario
    public void cadastraUsuario(Usuario usuario, Context tela){

        ContentValues obj = new ContentValues();
        obj.put("ID_USUARIO", usuario.getCodigo());
        obj.put("NOME", usuario.getNome());
        obj.put("CELULAR", usuario.getCelular());
        obj.put("EMAIL", usuario.getEmail());
        obj.put("SENHA", usuario.getSenha());
        DB.getInstance(tela).insert(SQL.TABLE_USUARIO, null, obj);
        Toast.makeText(tela, "Cadastro de usuario OK!", Toast.LENGTH_LONG).show();

    }

    public void loginUsuario(){


    }


}
