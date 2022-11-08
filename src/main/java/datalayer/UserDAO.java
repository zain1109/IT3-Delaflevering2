package datalayer;

import Setup.LoginData;

import java.sql.*;


public class UserDAO {



    public LoginData findUser(String brugernavn) {


        try {

            Class.forName(" ");
            String url = " ";
            String user = "";
            String pass = " ";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement statement = conn.createStatement();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM  WHERE  = ?;");
            preparedStatement.setString(1,brugernavn);
            ResultSet rs = preparedStatement.executeQuery();
            LoginData loginData=new LoginData();
            while (rs.next()) {
                String username = rs.getString(" ");
                String password = rs.getString(" ");
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


