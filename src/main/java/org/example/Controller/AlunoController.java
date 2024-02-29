package org.example.Controller;

import jakarta.persistence.NoResultException;
import org.example.DAO.AlunoDAO;
import org.example.Model.Aluno;

import java.util.List;

public class AlunoController {

    private AlunoDAO dao;

    // Construtor default
    public AlunoController(){}

    public AlunoController(AlunoDAO dao) {
        this.dao = dao;
    }

    public void listAprovados(){
        List<Aluno> aprovados = dao.aprovados();
        try{
            for (Aluno a:aprovados){
                System.out.println(a);
            }
        }catch(NoResultException e){
            System.out.println("Alunos não encontrados!");
        }
    }

    public Aluno encontrarPorNome(String nome){
        return dao.buscarPorNome(nome);
    }

    public void inserir(Aluno aluno){
        dao.iniciar();
        try{
            dao.cadastrar(aluno);
            dao.fixar();
        }catch(Exception e){
            dao.desfazer();
            System.out.println("Aluno não cadastrado!");
        }
    }

    public void excluir(Aluno aluno){
        dao.iniciar();
        try{
            dao.deletar(aluno);
            dao.fixar();
        }catch (Exception e){
            System.out.println("Aluno não encontrado!");
        }
    }

}
