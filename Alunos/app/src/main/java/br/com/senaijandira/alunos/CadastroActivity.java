package br.com.senaijandira.alunos;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 17259211 on 29/10/2018.
 */

public class CadastroActivity extends Activity{
    Button btnCadastrar;
    EditText edNome;
    EditText edDtNasc;
    EditText edCpf;
    EditText edNota1;
    EditText edNota2;
    EditText edNota3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_usuario);

        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edNome = findViewById(R.id.edNome);
                edDtNasc = findViewById(R.id.edDtNasc);
                edCpf = findViewById(R.id.edCpf);
                edNota1 = findViewById(R.id.edNota1);
                edNota2 = findViewById(R.id.edNota2);
                edNota3 = findViewById(R.id.edNota3);




            }
        });




    }
}
