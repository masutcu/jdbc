import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        //String sql01= "create table workers (worker_id int, worker_name varchar(30), worker_salary int)";
        //st.execute(sql01);
        //tabloya wokers adres sutunu ekleyelim
        //String sql02 = "Alter Table workers add worker_address varchar (50)";
        //st.execute(sql02);

        //Workers tablosunu silelim
        //String sql03= "Drop Table workers";
        //st.execute(sql03);
        con.close();
        st.close();


    }


}
