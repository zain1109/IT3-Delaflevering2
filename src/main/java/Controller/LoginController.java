package Controller;

import javax.ws.rs.WebApplicationException;
import dataAccesLayer.LoginSQL;
import model.LoginData;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
public class LoginController {

    private LoginController() {
    }

    static private final LoginController loginControllerOBJ = new LoginController();

    static public LoginController getLoginControllerOBJ() {
        return loginControllerOBJ;
    }

    public String doLogin(LoginData loginData) {
        try {
            // Eksistere en user i SQL
            String brugerListe = LoginSQL.getLoginSqlObj().returnLoginUserDB(loginData.getUsername());
            String[] opdelt = brugerListe.split("\\|");
            // kontrollere password
            if (hashControl(loginData.getPassword(), opdelt[1])) {
                User user = new User(loginData);
                if (opdelt[3].equals("1")) {
                    user.setDoctor(true);
                } else {
                    user.setDoctor(false);
                }
                //Give JavaWebToken
                return JWTHandler.generateJwtToken(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new WebApplicationException("fejl", 401);
    }
//her går vi ind og genererer en hash af det givne password ved hjælp af BCrypt biblioteket
    public static String generateHash(String pass) {
        String salt = (BCrypt.gensalt(10));
        System.out.println(salt);
        return BCrypt.hashpw(pass, salt); //Værdien, der bliver returneret af denne metode, er en hashet version af passwordet, der er sikkert at gemme i en database.

