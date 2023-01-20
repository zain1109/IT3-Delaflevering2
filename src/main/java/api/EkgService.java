package api;

import Controller.EkgController;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import exceptions.OurException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;


public class EkgService {

    // Indsætter EKG-data i databasen og returnerer de modtagne data
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
   /* public EkgData ekgpython(EkgData data, @Context HttpHeaders httpHeaders) {
        EkgController.getEkgControllerObj().insertPythonData(
                EkgController.getEkgControllerObj().insertHttpHeaders(
                        httpHeaders.getRequestHeader("Identifier").get(0),
                        httpHeaders.getRequestHeader("session").get(0),
                        httpHeaders.getRequestHeader("Timestart").get(0)
                ), data
        );
        return data;
    }
*/
    // Returnerer en liste af EKG-sessioner for et given CPR-nr.
    @GET
    public JsonElement getSession(@QueryParam("cpr") String cpr) throws SQLException, OurException {
        return EkgController.getEkgControllerObj().cprSearchEkg(cpr);
    }

    // Returnerer EKG-data for en given sessionID
    @Path("measurements")
    @GET
    public <EkgData> EkgData getEkgData(@QueryParam("sessionID") String sessionID){
        return (EkgData) EkgController.getEkgControllerObj().sessionSearchData(sessionID);
    }

    // Returnerer en liste over EKG-sessioner i JSON-format
    @Path("ekgSessionsJson")
    @GET
    public String getSessionJson(@QueryParam("cpr") String cpr) throws SQLException {
        return new Gson().toJson(EkgController.getEkgControllerObj().cprSearchEkg(cpr));
    }
}
