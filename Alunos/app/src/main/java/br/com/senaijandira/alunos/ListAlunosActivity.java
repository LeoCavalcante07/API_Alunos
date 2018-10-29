package br.com.senaijandira.alunos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.senaijandira.alunos.MainActivity.matricula;

public class ListAlunosActivity extends Activity {

    ListView lstAlunos;
    AlunosAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alunos);

        lstAlunos = findViewById(R.id.lstAlunos);
        adapter = new AlunosAdapter(this);
        lstAlunos.setAdapter(adapter);

        //Cria o serviço que chama a API
        AlunoService service = ServiceFactory.create();

        if(matricula == 0){


            //Chama a API  de alunos
            //Call<List<Aluno>> call = service.obterAlunos();
            Call<List<Aluno>> call = service.obterAlunos();

            //efetua a chamada da APIn
            call.enqueue(new Callback<List<Aluno>>() {
                @Override
                public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {

                    List<Aluno> alunos = response.body();

                    /*for(Aluno a: alunos){
                        Log.d("API_ALUNOS", a.getNome());
                        Log.d("API_ALUNOS","" +  a.getMatricula());

                    }*/

                    adapter.addAll(alunos);



                }

                @Override
                public void onFailure(Call<List<Aluno>> call, Throwable t) {
                    Log.e("ERRO_API", t.getMessage());
                }

            });


        }else{



            //Chama a API  de alunos
            //Call<List<Aluno>> call = service.obterAlunos();
            Call<Aluno> call = service.obterAlunoEspecifico(matricula);

            //efetua a chamada da APIn
            call.enqueue(new Callback<Aluno>() {
                @Override
                public void onResponse(Call<Aluno> call, Response<Aluno> response) {

                    Aluno alunos = response.body();

                /*for(Aluno a: alunos){
                    Log.d("API_ALUNOS", a.getNome());
                    Log.d("API_ALUNOS","" +  a.getMatricula());

                }*/

                    adapter.addAll(alunos);



                }

                @Override
                public void onFailure(Call<Aluno> call, Throwable t) {
                    Log.e("ERRO_API", t.getMessage());
                }

            });

        }




    }




    private class AlunosAdapter extends ArrayAdapter<Aluno> {

        public AlunosAdapter(Context contexto){
            super(contexto, 0, new ArrayList<Aluno>());
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            if(v == null){//SE v ESTIVER NULL É PORQUE ELE AINDA NÃO FOI INFLADO, LOGO ELE DEVE SER INFLADO
                v = LayoutInflater.from(getContext()).inflate(R.layout.list_aluno_layout, parent, false);
            }

            Aluno a = getItem(position);

            TextView txtNomeAluno = v.findViewById(R.id.txtNomeAluno);
            TextView txtNumeroMatricula = v.findViewById(R.id.txtNumeroMatricula);

            txtNomeAluno.setText(a.getNome());
            txtNumeroMatricula.setText(a.getMatricula()  +"");

            return v;
        }
    }

}
