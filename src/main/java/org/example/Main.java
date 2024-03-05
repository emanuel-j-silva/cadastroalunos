package org.example;

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
            System.out.println("5- Listar todos os alunos (com status aprovação)");
            System.out.println("6- SAIR");
            System.out.print("\n");
            System.out.print("Digite a opção desejada: ");
            option = teclado.nextInt();
            teclado.nextLine();
            switch (option){
                case 1:
                    Aluno aluno = cadastroAluno();
                    controller.inserir(aluno);
                    break;
                case 2:
                    controller.listTodos();
                    System.out.print("Digite o nome do aluno a ser removido:");
                    String nomeAluno = teclado.nextLine();
                    Aluno alunoDelete = controller.encontrarPorNome(nomeAluno);
                    controller.excluir(alunoDelete);
                    break;
                case 3:
                    controller.listTodos();
                    System.out.print("Digite o nome do aluno a ser alterado:");
                    String nomeAlu = teclado.nextLine();
                    Aluno alunoUpdate = controller.encontrarPorNome(nomeAlu);
                    if (alunoUpdate != null){
                        System.out.println("NOVOS DADOS:");
                        Aluno alu = cadastroAluno();

                        alunoUpdate.setNome(alu.getNome());
                        alunoUpdate.setRa(alu.getRa());
                        alunoUpdate.setEmail(alu.getEmail());
                        alunoUpdate.setNota1(alu.getNota1());
                        alunoUpdate.setNota2(alu.getNota2());
                        alunoUpdate.setNota3(alu.getNota3());
                        controller.atualizar(alunoUpdate);
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do aluno procurado:");
                    String nomeDoAluno = teclado.nextLine();
                    Aluno exibeAluno = controller.encontrarPorNome(nomeDoAluno);
                    if (exibeAluno != null) System.out.println(exibeAluno);
                    System.out.print("\n");
                    break;
                case 5:
                    controller.listStatus();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Unexpected value: " + option);
                    break;
            }
        }while(option!=6);
    }
    public static Aluno cadastroAluno(){
        Scanner teclado = new Scanner(System.in);
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
        return aluno;
    }
}