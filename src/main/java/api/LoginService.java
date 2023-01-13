package api;

import controller.LoginController;
import model.LoginData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class LoginService {

    // Kontrollerer brugerloginoplysninger og returnerer resultatet
    @GET
    public String loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass) {
        LoginData loginData = new LoginData(user, pass);
        return LoginController.getLoginControllerOBJ().doLogin(loginData);
    }
}
