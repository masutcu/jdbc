import utilities.DatabaseUtilty;

public class Quary09 {
    public static void main(String[] args) {

        DatabaseUtilty.createConnection();  //DatabaseUtility yi static olarak başa atarsak metodlar direk çağrılabilir.
        String sql01="select * from ogrenciler";
        System.out.println("Sutun İsimleri = " + DatabaseUtilty.getColumnNames(sql01));

        System.out.println("Öğrenci isimlerini = " + DatabaseUtilty.getColumnData(sql01, "ogrenci_ismi"));

        DatabaseUtilty.closeConnection();

    }
}
