package Controller;

import com.google.gson.JsonElement;

public class EkgController<EkgData> {

    private static Object getSqlOBJ;
    private static final Object SQL = getSqlOBJ;

    // Private konstruktør, så der kun kan oprettes et objekt af denne klasse
    private EkgController() {
    }

    // Statisk objekt af denne klasse, der kan bruges andre steder i programmet
    static private final EkgController EKG_CONTROLLER_OBJ = new EkgController();

    // Returnerer det statiske objekt af denne klasse
    static public EkgController  getEkgControllerObj() {
        return EKG_CONTROLLER_OBJ;
    }

    public JsonElement cprSearchEkg(String cpr) {
        return null;
    }

    public Object sessionSearchData(String sessionID) {
        return null;
    }

    // Indsætter et EkgSession-objekt og et EkgData-objekt i databasen ved hjælp af SQL-klassen
   /* public <EkgSession> void insertPythonData(Object ekgSession, EkgData ekgData){
        try {
            SQL.getSqlOBJ().insertSessionSQL(ekgSession);
            SQL.getSqlOBJ().creatDataSQL(ekgSession);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JsonElement cprSearchEkg(String cpr) {
        return null;
    }

    public Object insertHttpHeaders(String identifier, String session, String timestart) {
        return null;
    }

    public <EkgData> EkgData sessionSearchData(String sessionID) {
        return null;
    }

    */
}