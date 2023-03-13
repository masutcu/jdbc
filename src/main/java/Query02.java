import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1) Driver tanımama
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        //region id si 1 olan country name yazdır
        String sql01="select country_name from countries where region_id=1";

        ResultSet veri=st.executeQuery(sql01);
        while (veri.next()){
            System.out.println(veri.getString(1));
        }

        //region id>2 country id, country_name i verin
        String sql2="select country_name, country_id from countries where region_id>2";
        ResultSet veri1=st.executeQuery(sql2);
        while (veri1.next()){
            System.out.println(veri1.getString(1)+" "+veri1.getString(2));
        }
        con.close();
        st.close();
        veri.close();
        veri1.close();
    }
}
