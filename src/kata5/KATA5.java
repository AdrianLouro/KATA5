package kata5;

import java.io.*;
import java.sql.*;

public class KATA5 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conec = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
        Statement state = conec.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");

        while (rs.next()) {
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));
        }

//        String nameFile = "C:\\Users\\usuario\\Desktop\\KATA5\\data\\email.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
//
//        String mail;
//        while ((mail = reader.readLine()) != null) {
//            String query = "INSERT INTO MAIL (MAIL) VALUES ('" + mail + "')";
//            state.executeUpdate(query);
//        }
        
        rs.close();
        state.close();
        conec.close();
    }

}
