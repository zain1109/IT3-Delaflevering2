package Controller;

import Business.AftaleListe;
import exceptions.OurException;

import java.sql.SQLException;

public class AftaleController {

    // Private konstruktør, så der kun kan oprettes et objekt af denne klasse
    private AftaleController() {
    }

    // Statisk objekt af denne klasse, der kan bruges andre steder i programmet
    static private final AftaleController AFTALE_CONTROLLER_OBJ = new AftaleController();

    // Returnerer det statiske objekt af denne klasse
    static public AftaleController getAftaleControllerOBJ() {
        return AFTALE_CONTROLLER_OBJ;
    }

    // Tjekker, om en String indeholder 10 cifre
    public boolean cprCheck(String name) {
        try {
            double test = Double.parseDouble(name);
            return name.length() == 10;
        } catch (Exception e) {
            return false;
        }
    }

    // Returnerer en liste over aftaler for et givent CPR-nr. eller en tom liste, hvis CPR-nummeret er ugyldigt eller ikke angivet
    public AftaleListe cprSearch(String cpr) throws SQLException, OurException {
        if (cpr == null) {
            //return SQL.getSqlOBJ().getAftalerListe();
        }
        if (cprCheck(cpr)) {
            //return SQL.getSqlOBJ().cprSearch(cpr);
        }
        return new AftaleListe();
    }

    public String createAftale(String cpr, String timestart, String timeend, String notat) {
        return cpr;
    }
}

// Opretter en aftale med givne oplysninger ved hjælp af SQL-klassen. Hvis CPR-nummeret er ugyldigt eller noten er for lang, kastes en OurException med en passende fejlmeddelelse
  /*  public String createAftale(String cpr, String timestart, String timeend, String note) throws OurException {
        Aftale aftale = new Aftale();
        if (cprCheck(cpr)) {
            if (note.length() < 255) {
                aftale.setCPR(cpr);
                aftale.setTimeStart(timestart);
                aftale.setTimeEnd(timeend);
                aftale.setNotat(note);
                aftale.setKlinikID("4");

                SQL.getSqlOBJ().insertAftaleSQL(aftale);
                return "added patient" + aftale;
            } else {
                //forkert note
                OurException ex = new OurException();
                ex.setMessage("For lang note, skal være under 255 tegn.");
                throw ex;
            }
        } else {
            // forkert cpr
            OurException ex = new OurException();
            ex.setMessage("CPR skal være 10 cifre, yyyymmddxxxx");
            throw ex;
        }


    }
*/
