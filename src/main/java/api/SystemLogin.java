package api;

import Model.LoginData;

import javax.ws.rs.*;
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
}