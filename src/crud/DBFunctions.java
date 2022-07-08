package crud;

import java.sql.*;

public class DBFunctions {
    Connection conn = null;

    public  void connect(String password) {
        try {
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost/db_crud", "postgres", password);
            System.out.println("Conexao estabelecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //create
    public void create(String nome, String contato, String endereco) {
        Statement statement;
        try {
            String query = String.format("insert into pessoas (nome, contato, endereco) values ('%s', '%s', '%s');", nome, contato, endereco);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dado inserido!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //read(all)
    public void read_all() {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from pessoas");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id_pessoa") + " ");
                System.out.print(rs.getString("nome") + " ");
                System.out.print(rs.getString("contato") + " ");
                System.out.println(rs.getString("endereco") + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update
    public void updade_name(String old_name, String new_name) {
        Statement statement;
        try {
            String query = String.format("update pessoas set nome='%s' where nome='%s'", new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Campo atualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //read(id)
    public void read_id(Integer id_pessoa) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from pessoas where id_pessoa = '%s' ", id_pessoa);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id_pessoa") + " ");
                System.out.print(rs.getString("nome") + " ");
                System.out.print(rs.getString("contato") + " ");
                System.out.println(rs.getString("endereco") + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //delete(id)
    public void delete_id(Integer id) {
        Statement statement;
        try {
            String query = String.format("delete from pessoas where id_pessoa = '%s'", id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

