import java.sql.*;

public class Query01 {
    public static <Resultset> void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver tanımama
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        ResultSet veri=st.executeQuery("select * from ogrenciler"); //Data alırken
        while (veri.next()){
            System.out.println(veri.getInt(1)+" "+
                    veri.getString(2)+" "+
                    veri.getString(3)+" "+
                    veri.getString(4));
        }
        con.close();
        st.close();
        veri.close();

    }
}
