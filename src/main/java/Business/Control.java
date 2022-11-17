package Business;

import Setup.LoginData;
import datalayer.UserDAO;

import javax.ws.rs.WebApplicationException;


public class Control {
    private static UserDAO userDAO = new UserDAO();


    public String validateUser(LoginData loginData) {
        //Kontroller om der er en bruger der matcher username

        System.out.println(loginData);
        LoginData user = userDAO.findUser(loginData.getUsername());
        System.out.println(user);
        //Kontroller om der er en bruger med det rette kodeord?
        if (user !=null && user.getPassword().equals(loginData.getPassword())) {
            //returnere en token
            return Business.JWTHandler.generateJwtToken(loginData);

        }
        //Hvis login fejler, afvises der med en 401
        throw new WebApplicationException(401);
    }
}


