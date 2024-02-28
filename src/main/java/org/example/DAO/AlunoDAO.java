package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.Model.Aluno;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunoDAO {

    private EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Aluno aluno){
        this.em.persist(aluno);
    }

    public List<Aluno> buscarTodos(){
        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql,Aluno.class).getResultList();
    }

    public List<Aluno> aprovados(){
        return buscarTodos().stream()
                .filter(a -> a.getNota1().add(a.getNota2()).add(a.getNota3())
                .compareTo(new BigDecimal(18.0)) >= 0)
                .collect(Collectors.toList());
    }

    public Aluno buscarUm(Long id){
        String jpql = "SELECT a FROM Aluno a WHERE id = :1";
        return em.createQuery(jpql,Aluno.class)
                .setParameter(1,id)
                .getSingleResult();
    }

    public Aluno buscarPorNome(String nome){
        String jpql = "SELECT a FROM Aluno a WHERE nome = :1";
        return em.createQuery(jpql,Aluno.class)
                .setParameter(1,nome)
                .getSingleResult();
    }
}
