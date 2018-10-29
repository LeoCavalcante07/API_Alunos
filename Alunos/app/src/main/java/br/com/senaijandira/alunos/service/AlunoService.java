package br.com.senaijandira.alunos.service;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlunoService {

    String URL_BASE = "http://10.0.2.2:5001/"; // o IP 10.0.2.2 é o padrao que o android cria que ele conhece a maquina que o emulador tá rodando

    @GET("/alunos") // quando na url for digitado /alunos, retorne uma vista
    Call<List<Aluno>> obterAlunos();

    @GET("/aluno/{id}")
    Call<Aluno> obterAlunoEspecifico(@Path("id") int id);

}
