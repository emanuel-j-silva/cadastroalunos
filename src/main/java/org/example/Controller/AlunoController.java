package org.example.Controller;

import jakarta.persistence.NoResultException;
import org.example.DAO.AlunoDAO;
import org.example.Model.Aluno;

import java.util.List;
import java.util.Optional;

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

}
