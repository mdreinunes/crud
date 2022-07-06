package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFunctions {
    public Connection connect_to_db(String dbnome, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbnome, user, pass);
            if (conn != null) {
                System.out.println("Conexao estabelecida!");
            } else {
                System.out.println("Conexao falhada!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    //create(table)
    public void createTable(Connection conn, String tabela) {
        Statement statement;
        try {
            String query = "create table " + tabela + "(id_pessoa INTEGER ,nome varchar(200),endereco varchar(200), contato varchar(200),primary key(id_pessoa));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela criada!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //create
    public void inserir(Connection conn, String tabela, Integer id, String nome, String contato, String endereco) {
        Statement statement;
        try {
            String query = String.format("insert into %s (id_pessoa, nome, contato, endereco) values ('%s', '%s', '%s', '%s');", tabela, id, nome, contato, endereco);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dado inserido!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //read(all)
    public void read_all(Connection conn, String tabela) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s", tabela);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id_pessoa") + " ");
                System.out.print(rs.getString("nome") + " ");
                System.out.print(rs.getString("contato") + " ");
                System.out.println(rs.getString("endereco") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //update
    public void updade_name(Connection conn, String tabela, String old_name, String new_name) {
        Statement statement;
        try {
            String query = String.format("update %s set nome='%s' where nome='%s'", tabela, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Campo atualizado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //read(id)
    public void read_id(Connection conn, String tabela, Integer id_pessoa) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where id_pessoa = '%s' ", tabela, id_pessoa);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id_pessoa") + " ");
                System.out.print(rs.getString("nome") + " ");
                System.out.print(rs.getString("contato") + " ");
                System.out.println(rs.getString("endereco") + " ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //delete(id)
    public void delete_id(Connection conn, String tabela, Integer id) {
        Statement statement;
        try {
            String query = String.format("delete from %s where id_pessoa = '%s'", tabela, id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Deletado com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //delete(tabe)
    public void delete_table(Connection conn, String tabela) {
        Statement statement;
        try {
            String query = String.format("drop table %s", tabela);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela deletada!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

