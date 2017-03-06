package com.developer.allef.gestaocontrol.View;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.developer.allef.gestaocontrol.BD.UsuarioBD;
import com.developer.allef.gestaocontrol.Model.Usuario;
import com.developer.allef.gestaocontrol.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListarUsuarios extends AppCompatActivity {
    @BindView(R.id.list) ListView lis;
    List<Usuario> tes,te;
    ArrayList<String> arrayList = new ArrayList<>();

    UsuarioBD bd;
    private static final String campos[] = {"nome", "endereco", "telefone", "_id"};
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toll);
        setSupportActionBar(toolbar);
        Usuario user = new Usuario();
        bd = new UsuarioBD(this);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        database = bd.getWritableDatabase();
        Cursor cursor = bd.carregaDados();

        tes = bd.getAll();


        Toast.makeText(ListarUsuarios.this,"Tamanho = "+bd.getAll().size(),Toast.LENGTH_LONG).show();

            for(int i =1; i<tes.size();i++){
               arrayList.add(tes.get(i).getNome().toString());

            }



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        lis.setAdapter(adapter);


    }

}
