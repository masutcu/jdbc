package pojos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Quary07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();

        //SORU: Ürünler adında bir tablo oluşturalım

        //resultSet karşıdan data almak için kullanılır. karşıya data gönderirken kullanılmaz.
        //String sql01="create table Urunler (id int, isim varchar(10), fiyat int)";
        //st.execute(sql01);

        List<Urun> kayitlar=new ArrayList<>();
        kayitlar.add(new Urun(100,"LapTop",35000));
        kayitlar.add(new Urun(101,"Ipad",45000));
        kayitlar.add(new Urun(102,"McBook",65000));
        kayitlar.add(new Urun(103,"Lenovo",25000));
        kayitlar.add(new Urun(104,"Hp",20000));
        kayitlar.add(new Urun(105,"Casper",15000));

        //Çok miktarda data eklemek için PreparedStatement kullanmalıyız
        PreparedStatement tablo=con.prepareStatement("insert into urunler values(?,?,?)");
        for(Urun each:kayitlar){
            tablo.setInt(1,each.getId());
            tablo.setString(2,each.getIsim());
            tablo.setDouble(3,each.getFiyat());
            tablo.addBatch();

        }tablo.executeBatch();









    }



}
