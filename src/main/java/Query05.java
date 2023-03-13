import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        // öğrenciler tablosuna yeni bir kayıt ekleyin  (300,'Sena Can',12,'K')
        //String sql01="insert into ogrenciler values (300,'Sena Can',12,'K')";
        //st.executeUpdate(sql01); //data gönderirken

        //4 farklı öğrenci ekleyelim
        String[] veri={"insert into ogrenciler values (301,'Ali Can',15,'E')",
                "insert into ogrenciler values (302,'Veli Han',10,'E')",
                "insert into ogrenciler values (303,'Ayse Türk',22,'K')"};
        int count=0;
        for(String each:veri){
            count=count+st.executeUpdate(each);
        }
        System.out.println(count +" adet  satır eklendi");

    }
}
