package api;

import Setup.LoginData;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("login")
public class SystemLogin {
    private static SystemLogin loginCon = new SystemLogin();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    // Modtager deserialiserede data fra frontenden og sender til Java-Object
    public String doLogin(LoginData loginData){
        //returner en valideret token (hvis lykkedes) til klienten
        String token = loginCon.validateUser(loginData);
        System.out.println(token);
        return token;
    }

    private String validateUser(LoginData loginData){
        return null;
    }
}