package org.example.Controller;

import jakarta.persistence.NoResultException;
import org.example.DAO.AlunoDAO;
import org.example.Model.Aluno;

import java.math.BigDecimal;
import java.util.List;

public class AlunoController {

    private AlunoDAO dao;

    // Construtor default
    public AlunoController(){}

    public AlunoController(AlunoDAO dao) {
        this.dao = dao;
    }

    public void listStatus(){
        List<Aluno> alunos = dao.buscarTodos();
        try{
            for (Aluno a:alunos){
                BigDecimal somaNotas =
                        new BigDecimal(String.valueOf(a.getNota1().add(a.getNota2().add(a.getNota3()))));
                BigDecimal media =
                        new BigDecimal(String.valueOf(somaNotas.divide(BigDecimal.valueOf(3),2)));
                System.out.println(a);
                System.out.println(media);

                if (somaNotas.compareTo(new BigDecimal(12)) < 0) System.out.println("Reprovado");
                else if (somaNotas.compareTo(new BigDecimal(18)) < 0) System.out.println("Recuperação");
                else System.out.println("Aprovado");
                System.out.print("\n");
            }
        }catch(NoResultException e){
            System.out.println("Alunos não encontrados!");
        }
    }

    public void listTodos(){
        List<Aluno> todos = dao.buscarTodos();
        try{
            for(Aluno a:todos){
                System.out.println(a);
                System.out.print("\n");
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
            System.out.println("Aluno inserido com sucesso!");
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
            System.out.println("Aluno deletado com sucesso!");
        }catch (Exception e){
            dao.desfazer();
            System.out.println("Aluno não deletado!");
        }
    }

    public void atualizar(Aluno aluno){
        dao.iniciar();
        try{
            dao.atualizar(aluno);
            dao.fixar();
            System.out.println("Aluno atualizado com sucesso!");
        }catch (Exception e){
            dao.desfazer();
            System.out.println("Aluno não atualizado!");
        }
    }

}
