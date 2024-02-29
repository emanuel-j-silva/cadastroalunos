package org.example;

import jakarta.persistence.EntityManager;
import org.example.Controller.AlunoController;
import org.example.DAO.AlunoDAO;
import org.example.Model.Aluno;
import org.example.Utils.JPAUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
        AlunoController controller = new AlunoController(new AlunoDAO(JPAUtil.getEntityManager()));


        Scanner teclado = new Scanner(System.in);
        int option;
        do{
            System.out.println("SISTEMA DE CADASTRO DE ALUNOS");
            System.out.println("1- Cadastrar aluno");
            System.out.println("2- Excluir aluno");
            System.out.println("3- Alterar aluno");
            System.out.println("4- Buscar aluno pelo nome");
            System.out.println("5- Listar alunos (com status aprovação");
            System.out.println("6- SAIR");
            System.out.print("\n");
            System.out.print("Digite a opção desejada: ");
            option = teclado.nextInt();
            teclado.nextLine();
            switch (option){
                case 1:
                    System.out.print("\n");
                    System.out.print("Digite o nome:");
                    String nome = teclado.nextLine();
                    System.out.print("\n");
                    System.out.print("Digite o RA:");
                    String ra = teclado.nextLine();
                    System.out.print("\n");
                    System.out.print("Digite o email:");
                    String email = teclado.nextLine();
                    System.out.print("\n");
                    System.out.print("Nota 1:");
                    BigDecimal nota1 = teclado.nextBigDecimal();
                    System.out.print("\n");
                    System.out.print("Nota 2:");
                    BigDecimal nota2 = teclado.nextBigDecimal();
                    System.out.print("\n");
                    System.out.print("Nota 3:");
                    BigDecimal nota3 = teclado.nextBigDecimal();
                    System.out.print("\n");

                    Aluno aluno = new Aluno(nome,ra,email,nota1,nota2,nota3);
                    controller.inserir(aluno);
                    break;
                case 2:
                    //LISTAR TODOS OS ALUNOS
                    //ANTES DE FAZER A REMOÇÃO
                    System.out.print("Digite o nome do aluno a ser removido:");
                    String nomeAluno = teclado.nextLine();
                    Aluno alunoDelete = controller.encontrarPorNome(nomeAluno);
                    controller.excluir(alunoDelete);
                    break;
                case 3:;
                case 4:;
                case 5:
                    controller.listAprovados();
                    break;
                case 6:
                    System.out.println("Saindo...");
            }
        }while(option!=6);
    }
}