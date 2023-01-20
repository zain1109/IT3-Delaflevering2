package datalayer;

import Setup.LoginData;

import java.sql.*;


public class UserDAO {

    public static LoginData findUser(String brugernavn) {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://mysql-db.caprover.diplomportal.dk:3306/s215852";
            String user = "s215852";
            String pass = "si2AKXMXGbAqpe54OAWLX";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement statement = conn.createStatement();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Sundhedspersonale WHERE IT3 = ?;");
            preparedStatement.setString(1,brugernavn);
            ResultSet rs = preparedStatement.executeQuery();
            LoginData loginData=new LoginData();
            while (rs.next()) {
                String username = rs.getString("Brugernavn");
                String password = rs.getString("Adgangskode");
                System.out.println(username);
                System.out.println(password);
                loginData.setUsername(username);
                loginData.setPassword(password);
            statement.close();
            return loginData;

        }} catch (Exception e) {
            System.err.println("Exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
}


