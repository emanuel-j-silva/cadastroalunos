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
            System.out.println("Alunos aprovados não encontrados!");
        }
    }

    public void listTodos(){
        List<Aluno> todos = dao.buscarTodos();
        try{
            for(Aluno a:todos){
                System.out.println(a);
            }
        }catch (NoResultException e){
            System.out.println("Alunos não encontrados!");
        }
    }

    public Aluno encontrarPorNome(String nome) {
        Aluno aluno = null;
        try {
            aluno = dao.buscarPorNome(nome);
        } catch (Exception e) {
            System.out.println("Aluno não encontrado!");
        }
        return aluno;
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
            System.out.println("Aluno não deletado!");
        }
    }

    public void atualizar(Aluno aluno){
        dao.iniciar();
        try{
            dao.atualizar(aluno);
            dao.fixar();
        }catch (Exception e){
            System.out.println("Aluno não atualizado!");
        }
    }

}
