import java.sql.*;

public class Quary06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        PreparedStatement ps= con.prepareStatement("insert into ogrenciler values (?,?,?,?)");
        ps.setInt(1,950);
        ps.setString(2,"Ali Can");
        ps.setInt(3,12);
        ps.setString(4,"E");

        ps.executeUpdate();


        ps.close();





    }
}
