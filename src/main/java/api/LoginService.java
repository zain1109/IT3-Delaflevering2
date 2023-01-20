package api;

import Controller.LoginController;
import Setup.LoginData;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

public class LoginService {

    // Kontrollerer brugerloginoplysninger og returnerer resultatet
    @GET
    public String loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass) {
        LoginData loginData = new LoginData();
        return LoginController.getLoginControllerOBJ().doLogin(loginData);
    }
}
