package Controller;

import Setup.LoginData;
import datalayer.UserDAO;

import javax.ws.rs.WebApplicationException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginController {

    private LoginController() {
    }

    static private final LoginController loginControllerOBJ = new LoginController();

    static public LoginController getLoginControllerOBJ() {
        return loginControllerOBJ;
    }

    public String doLogin(LoginData loginData) {
        // sql kald der kontrollere om brugeren eksitere
        LoginData userData = null;
        String brugerListe = String.valueOf(UserDAO.findUser(userData.getUsername()));
        System.out.println(loginData.getUsername());

        // kontrol af login og generer token
        if (loginVal(brugerListe, loginData.getPassword())) {
            User user = new User(loginData);
            LoginData User = null;
            return JWTHandler.generateJwtToken(User);
        }
        throw new WebApplicationException("fejl", 401);
    }

    public boolean loginVal(String brugerliste, String pass) {
        if (brugerliste.length() > 1) {
            String[] opdelt = brugerliste.split("\\|");
            int salt = Integer.parseInt(opdelt[2]);
            String hashcheck = generateHash(pass, salt);
            if (opdelt[1].equals(hashcheck)) {
                return true;
            }
        }
        return false;
    }

    public static String generateHash(String pass, int salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            pass += String.valueOf(salt);
            md5.update(StandardCharsets.UTF_8.encode(pass));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pass;
    }

}

