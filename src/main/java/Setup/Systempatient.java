package Setup;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

@Path("Opretkonsultation") //Skal samles op og bruges af tomcat
public class Systempatient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //Metoden Opretkonsutation får sin script asynfuction henOpretkonsultation(), den splittes op fra bearer og herefter valideres i Keyhandler hvis den godkendes
    //Hvis adgang til dataen haves
    public List<Opretkonsultation> getOpretkonsultation(@HeaderParam("authorization") String token) throws SQLException {//validere en token
        String s = token.split(" ")[1];
        StampedLock Keyhandler = null;
        Keyhandler.validate(Long.parseLong(s));
        return PatientData.getInstance().getOpretkonsultation();

    }

    @GET
    @Path("{cpr}")
    public String Opretkonsultation(@PathParam("cpr") String cpr) {//

        return null;

    }


    @POST@Consumes(MediaType.APPLICATION_JSON)// @consumes fortæller at disse data skal seraliseres
    @Produces(MediaType.APPLICATION_JSON)

    public Opretkonsultation postOpretkonsultation(Opretkonsultation a) throws SQLException {
        System.out.println(a.getCpr());
        System.out.println(a.getName());
        System.out.println(a.gettidspunkt());
        System.out.println(a.getdato());
        System.out.println(a.getnotat());
        PatientData.getInstance().savekonsultation(a);
        Response.status(400).entity("message").build();
        return a;

    }
}






