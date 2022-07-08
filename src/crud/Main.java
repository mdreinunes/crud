package crud;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DBFunctions db = new DBFunctions();

        System.out.println("Digite a senha do banco de dados: ");
        String pass = scan.next();

        db.connect(pass);

        if (db.conn != null) {
            int operacoes;
            do {
                System.out.println("Operaçoes: 1 = create || 2 = read(all) || 3 = read(one) || 4 = update || 5 = delete || 0 para sair ");
                operacoes = scan.nextInt();

                if (operacoes == 1) {
                    System.out.println("Digite o nome: ");
                    String nome = scan.next();

                    System.out.println("Digite o contato: ");
                    String contato = scan.next();

                    System.out.println("Digite o endereco: ");
                    String endereco = scan.next();

                    db.create(nome, contato, endereco);
                } else if (operacoes == 2) {
                    db.read_all();

                } else if (operacoes == 3) {
                    System.out.println("Digite o id: ");
                    Integer id = scan.nextInt();

                    db.read_id(id);
                } else if (operacoes == 4) {
                    System.out.println("Nome antigo");
                    String antigo = scan.next();

                    System.out.println("Nome novo: ");
                    String novo = scan.next();

                    db.updade_name(antigo, novo);
                } else if (operacoes == 5) {

                    System.out.println("Digite o id para deletar: ");
                    Integer id = scan.nextInt();
                    db.delete_id(id);
                }

            } while (operacoes != 0);
        }


    }

}
