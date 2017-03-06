package com.developer.allef.gestaocontrol.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.developer.allef.gestaocontrol.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allef on 19/02/2017.
 */

public class UsuarioBD extends SQLiteOpenHelper {
    private static final String TAG = "sql";

    // nome do banco
    public static final String NOME_BANCO = "gestao";
    private static final int VERSAO_BANCO = 1;
    private static final String TABELA = "usuario";


    public UsuarioBD(Context context) {
        super(context, NOME_BANCO,null,VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"Criando a tabela carro");
        db.execSQL("create table if not exists " +TABELA +
                "(_id integer primary key autoincrement," +
                "nome text," +
                "email text);");
        Log.d(TAG,"Tabala usuario criada com sucesso !!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public String insereDado(Usuario us){
        ContentValues valores;
        long resultado;
        SQLiteDatabase db;

        db = getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome",us.getNome());
        valores.put("email",us.getEmail());

        resultado = db.insert("usuario", null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }
    public Cursor carregaDados(){
        SQLiteDatabase db;
        Cursor c;
        String[] cam = new String[]{"nome"};
        db = getWritableDatabase();
        c=db.query("usuario", cam, null, null, null, null, null, null);

        if(c!=null){
            c.moveToFirst();
        }
        db.close();
        return c;
    }


    public long PostPutUsuario(Usuario usuario){
        long id = usuario.getCodigo();
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("nome",usuario.getNome());
            values.put("email",usuario.getEmail());
            if(id == 0){
                String _id = String.valueOf(usuario.getCodigo());
                String [] where = new String[]{_id};

                //update usuario set values = ..... where _id=?
                int count = db.update("usuario",values,"_id=?",where);
                return count;
            }else{
                // insert into usuarios values
                id = db.insert("usuario","",values);
                return id;
            }
        }finally {
            db.close();
        }

    }
    public int deleteUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();

        try{
            // delete from usuario where _id=?
            int count = db.delete("usuario","_id=?",new String[]{String.valueOf(usuario.getCodigo())});
            Log.d(TAG,"deletou [ "+count+" ] dos Registros");
            return  count;
        }finally {
            db.close();
        }
    }

    public List<Usuario>getAll() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            // select * from usuario
            Cursor c = db.query("usuario", null, null, null, null, null, null);

            List<Usuario> usuario = new ArrayList<Usuario>();

            while(c.moveToNext()){
                Usuario u = new Usuario();
                u.setNome(c.getString(c.getColumnIndex("usuario.nome")));
                u.setEmail(c.getString(c.getColumnIndex("usuario.email")));
                usuario.add(u);

            }
            c.close();
            db.close();
            return usuario;


          //  return toList(c);
        } finally {
            db.close();
        }
    }




    public List<Usuario> toList(Cursor c) {
        List<Usuario> usuario = new ArrayList<Usuario>();
        if(c.moveToFirst()){
            do{
                Usuario user = new Usuario();
                usuario.add(user);

                // recuperando atributo de usuario
                user.setCodigo(c.getLong(c.getColumnIndex("_id")));
                user.setNome(c.getString(c.getColumnIndex("nome")));
                user.setEmail(c.getString(c.getColumnIndex("email")));
            }while (c.moveToNext());
        }
        return usuario;
    }

    public void execSQL(String sql){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.execSQL(sql);
        }finally {
            db.close();
        }
    }




}
