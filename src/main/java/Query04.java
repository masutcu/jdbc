import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery("select * from ogrenciler");
        ResultSetMetaData rmsd=rs.getMetaData();
        System.out.println("Birinci sutunun ismi : "+rmsd.getColumnName(1));
        System.out.println("ikinci sutunun ismi : "+rmsd.getColumnName(2));
        System.out.println("üçüncü sutunun ismi : "+rmsd.getColumnName(3));
        System.out.println("dördüncü sutunun ismi : "+rmsd.getColumnName(4));

        System.out.println("Tablo ismi = " + rmsd.getTableName(3));

    }
}
