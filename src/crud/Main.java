package crud;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DBFunctions db = new DBFunctions();
        Connection conn = db.connect_to_db("db_crud","postgres","aquario481");

        //db.createTable(conn, "pessoas");
        //db.inserir(conn, "pessoas", 1,"Beltrano","beltrano@hotmail.com","Matão");
        //db.inserir(conn, "pessoas", 4,"Fulano","fulano@hotmail.com","SP");
        //db.inserir(conn, "pessoas", 8,"Ciclano","ciclano@hotmail.com","RJ");
        //db.read_all(conn, "pessoas");
        //db.updade_name(conn,"pessoas","Fulano","Matheus");
        //db.read_id(conn, "pessoas",4);
        //db.delete_id(conn,"pessoas",4);
        //db.delete_table(conn, "pessoas");

    }

}
