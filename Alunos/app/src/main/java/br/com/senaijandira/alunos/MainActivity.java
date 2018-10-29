package br.com.senaijandira.alunos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edMatricula;
    static int matricula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMatricula = findViewById(R.id.edMatricula);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void chamarApi(View view) {

        //int matricula = Integer.valueOf(edMatricula.getText().toString());
        matricula = Integer.valueOf(edMatricula.getText().toString());



        startActivity(new Intent(this, ListAlunosActivity.class));

    }

    public void cadastrarUsuario(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }
}
