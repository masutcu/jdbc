package pojos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Quary08 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //2)Database e bağlan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Litvanya123");

        //3)Statement
        Statement st=con.createStatement();
        //doktorlar tablosunu oluşturun
        //String sql01="create table doctors (id int,isim varchar(30),bolum varchar(20),ucret int)";
        //st.execute(sql01);


        List<Doctor> kayitlar=new ArrayList<>();
        kayitlar.add(new Doctor(100,"Ali Kemal","KBB",25000));
        kayitlar.add(new Doctor(101,"Hacı Kemal","Dahiliye",35000));
        kayitlar.add(new Doctor(102,"Nuri Kemal","Üroloji",35000));
        kayitlar.add(new Doctor(103,"Hasan Kemal","Nöroloji",25000));
        kayitlar.add(new Doctor(104,"Ayse Kemal","Ortopedi",20000));
        kayitlar.add(new Doctor(105,"Fatma Kemal","Kardiyoloji",43000));
        PreparedStatement data=con.prepareStatement("insert into doctors values(?,?,?,?)");
        for(Doctor each:kayitlar){
            data.setInt(1,each.getId());
            data.setString(2,each.getIsim());
            data.setString(3,each.getBolum());
            data.setDouble(4,each.getUcret());
            data.addBatch();
        }data.executeBatch();
        con.close();
        data.close();

    }
}
