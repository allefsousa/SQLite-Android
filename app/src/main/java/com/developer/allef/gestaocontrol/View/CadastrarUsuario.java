package com.developer.allef.gestaocontrol.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.allef.gestaocontrol.BD.UsuarioBD;
import com.developer.allef.gestaocontrol.Model.Usuario;
import com.developer.allef.gestaocontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastrarUsuario extends AppCompatActivity {

     @BindView(R.id.labelid) TextInputLayout erid;
     @BindView(R.id.labelNome)TextInputLayout erNome;
     @BindView(R.id.labelemail)TextInputLayout erEmail;
     @BindView(R.id.btnsalvar)Button btnsalvar;
     @BindView(R.id.id) EditText txtid;
     @BindView(R.id.nome)EditText txtnome;
     @BindView(R.id.email)EditText txtemail;
    private UsuarioBD bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tes);
        setSupportActionBar(toolbar);
        bd = new UsuarioBD(this);
        ButterKnife.bind(this);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario us = new Usuario();
                bd = new UsuarioBD(getBaseContext());
                //us.setCodigo(Long.parseLong(txtid.getText().toString()));
                us.setNome(txtnome.getText().toString());
                us.setEmail(txtemail.getText().toString());
                bd.insereDado(us);
               // bd.PostPutUsuario(us);
                Toast.makeText(CadastrarUsuario.this,"Usuario salvo co sucesso" + us.toString(),Toast.LENGTH_LONG).show();
                Log.d("salvando","dados salvos com sucesso !! ");
            }
        });


    }

}
