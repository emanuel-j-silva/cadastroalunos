package org.example;

import jakarta.persistence.EntityManager;
import org.example.Controller.AlunoController;
import org.example.DAO.AlunoDAO;
import org.example.Utils.JPAUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
        AlunoController controller = new AlunoController();


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
            System.out.println("\n");
            System.out.println("Digite a opção desejada: ");
            option = teclado.nextInt();
            switch (option){
                case 1:
                    System.out.println("FUNÇÃO 1 CHAMADA");
                    break;
                case 2:
                    System.out.println("FUNÇÃO 2 CHAMADA");
                    break;
                case 3:;
                case 4:;
                case 5:controller.listAprovados();
                case 6:
                    System.out.println("Saindo...");
            }
        }while(option!=6);
        System.out.println("Hello World!");
    }
}