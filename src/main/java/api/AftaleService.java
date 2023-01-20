package api;

import Business.AftaleListe;
import Controller.AftaleController;
import exceptions.OurException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

public class AftaleService {

    // Returnerer en liste af aftaler for en given CPR-nr.
    @GET
    public AftaleListe getPatient(@QueryParam("cpr") String cpr) throws SQLException, OurException {
        return AftaleController.getAftaleControllerOBJ().cprSearch(cpr);
    }

    // Opretter en ny aftale i databasen og returnerer en tekstmeddelelse
    @Path("aftalerSQL")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String makepatientSQL(@QueryParam("cpr") String cpr, @QueryParam("timestart")
    String timestart, @QueryParam("timeend") String timeend, @QueryParam("note") String notat) throws SQLException, OurException {
        return AftaleController.getAftaleControllerOBJ().createAftale(cpr, timestart, timeend, notat);
    }

    // Returnerer en liste over aftaler mellem to tidspunkter i JSON-format
  //  @Path("aftalerSQL")
   // @GET
 //   public String selectFromTime(@QueryParam("from") String from, @QueryParam("to") String to) throws SQLException {
      //  return new Gson().toJson(SQL.getSqlOBJ().getAftaleListeDateTime(from, to));
    }
