package com.example.charles.myappmaps.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.charles.myappmaps.model.Academia;
import com.example.charles.myappmaps.model.Usuario;
import com.example.charles.myappmaps.util.SQL;

import java.util.ArrayList;

/**
 * Created by EdivaGt on 18/05/2016.
 */
public class BaseDado extends SQLiteOpenHelper {


    private SQLiteDatabase bd;
    private Context context;

    public BaseDado(Context context) {
        super(context, SQL.DBNAME, null, SQL.DBVERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // ** Criação das Tabelas
        Log.i("i", "Erro ao criar tabelas");
        db.execSQL(SQL.CREATE_USUARIO);
        Toast.makeText(context, "Criação da tabela Usuario Ok!", Toast.LENGTH_LONG).show();
        db.execSQL(SQL.CREATE_ACADEMIA);
        Toast.makeText(context, "Criação da tabela Academia OK!", Toast.LENGTH_LONG).show();

        Toast.makeText(context, "Tabelas Academia E usuario  criadas com sucesso!!!!",
                Toast.LENGTH_LONG).show();



        // ** Criação do Usuario para teste no banco
        ContentValues obj = new ContentValues();
        obj.put("ID_USUARIO", "1");
        obj.put("NOME", "JUCA BALA");
        obj.put("CELULAR", "4199991234");
        obj.put("EMAIL", "juca@gmail");
        obj.put("SENHA", "1029");
        db.insert(SQL.TABLE_USUARIO, null, obj);
        Toast.makeText(context, "Insert de usuario OK!", Toast.LENGTH_LONG).show();

        // ** Criação das Academias para teste no banco
        obj = new ContentValues();
        obj.put("ID_ACADEMIA", "1");
        obj.put("NOME", "Fitens optmos");
        obj.put("CELULAR", "4543535353");
        obj.put("FAVORITA", "1");
        obj.put("ID_USUARIOL", "1");
        db.insert(SQL.TABLE_USUARIO, null, obj);
        Toast.makeText(context, "Insert primeira academia OK!", Toast.LENGTH_LONG).show();

        obj = new ContentValues();
        obj.put("ID_ACADEMIA", "2");
        obj.put("NOME", "Atha Fitens ");
        obj.put("CELULAR", "324242424");
        obj.put("FAVORITA", "0");
        obj.put("ID_USUARIOL", "1");
        db.insert(SQL.TABLE_USUARIO, null, obj);
        Toast.makeText(context, "Insert segunda academia OK!", Toast.LENGTH_LONG).show();

        obj = new ContentValues();
        obj.put("ID_ACADEMIA", "3");
        obj.put("NOME", "Gay Fitens");
        obj.put("CELULAR", "454545353");
        obj.put("FAVORITA", "1");
        obj.put("ID_USUARIOL", "1");
        db.insert(SQL.TABLE_USUARIO, null, obj);
        Toast.makeText(context, "Insert terceira academia OK!", Toast.LENGTH_LONG).show();

        obj = new ContentValues();
        obj.put("ID_ACADEMIA", "4");
        obj.put("NOME", "America Fitens");
        obj.put("CELULAR", "45435324242");
        obj.put("FAVORITA", "0");
        obj.put("ID_USUARIOL", "1");
        db.insert(SQL.TABLE_USUARIO, null, obj);
        Toast.makeText(context, "Insert quarta academia OK!", Toast.LENGTH_LONG).show();


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insert(String table, ContentValues values, ContentValues obj) {
        bd = this.getWritableDatabase();

        long row = bd.insert(table, null, values);
        bd.close();

        return row;
    }


    //Metedo devolve usuario do aparelho
    public Usuario getUsuario(String email, String senhaUser ) {
        Usuario usuario = null;
        bd = this.getReadableDatabase();

        Cursor cursor = bd.rawQuery(SQL.GET_USUARIO,
                new String[]{email});
        cursor.moveToFirst();
        //
        while (!cursor.isAfterLast()) {
            usuario = new Usuario();

            try {
                usuario.setCodigo(cursor.getInt(0));
                usuario.setNome(cursor.getString(1));
                usuario.setCelular(cursor.getString(2));
                usuario.setEmail(cursor.getString(3));
                usuario.setSenha(cursor.getString(4));


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            cursor.moveToNext();
        }
        cursor.close();


        if(usuario!=null) {
            Log.i("Dados do Usuario", usuario.getNome()+" "+ usuario.getEmail());
            if (usuario.getSenha().equals(senhaUser)){
                 usuario=null;
                Log.i("Usuario"," diferente");
              }

            Log.i("Usuario"," Ok");

        }
          return usuario;
    }


    //Metodo de devolve a lista de academias
    public ArrayList<Academia> getAllAcademias() {

        ArrayList<Academia> result = new ArrayList<Academia>();

        bd = this.getReadableDatabase();
        Cursor cursor = bd.rawQuery(SQL.GET_ACADEMIA_ALL, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Academia academia = new Academia();

            try {
                academia.setCodigo(cursor.getInt(0));
                academia.setNome(cursor.getString(1));
                academia.setTelefone(cursor.getString(2));
                boolean bool=false;
                if(cursor.getInt(3)==1) bool=true;
                academia.setFavorito(bool);
                academia.usuario.setCodigo(cursor.getInt(4));

                Log.i("Academia:", academia.getNome());
            } catch (Exception e) {

                System.out.println(e.getMessage());
            } finally {

                result.add(academia);
            }

            cursor.moveToNext();
        }

        Log.i("Lista","Ok");
        cursor.close();

        return result;
    }
}
