package com.developer.allef.gestaocontrol.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.developer.allef.gestaocontrol.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button = (Button)findViewById(R.id.btncoletar);
        //region Toolbar Configuration
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //endregion

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListarUsuarios.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.Cadastrar){
            startActivity(new Intent(MainActivity.this,CadastrarUsuario.class));
        }
        if(id == R.id.editar){
            startActivity(new Intent(MainActivity.this,ListarUsuarios.class));

        } if(id == R.id.Conf){

        } if(id == R.id.sair){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
