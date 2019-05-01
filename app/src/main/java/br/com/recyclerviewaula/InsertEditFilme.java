package br.com.recyclerviewaula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class InsertEditFilme extends AppCompatActivity {

     EditText titulo;
     EditText genero;
     EditText ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_edit_filme);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo =  (EditText)findViewById(R.id.digitarTitulo);
        genero = (EditText)findViewById(R.id.digitarGenero);
        ano = (EditText)findViewById(R.id.digitarAno);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filme filme = new Filme();
                filme.setAno(Integer.valueOf(ano.getText().toString()));
                filme.setGenero(genero.getText().toString());
                filme.setTitulo(titulo.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putSerializable("filme", filme);
                Intent returnIntent = new Intent();
                returnIntent.putExtras(bundle);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

            }
        });
    }

}
