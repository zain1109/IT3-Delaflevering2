package Controller;

import dataAccesLayer.SQL;
import exceptions.OurException;
import model.AftaleListe;
import model.EkgData;
import model.EkgSession;
import model.EkgSessionList;

import java.sql.SQLException;

public class EkgController {

    // Private konstruktør, så der kun kan oprettes et objekt af denne klasse
    private EkgController() {
    }

    // Statisk objekt af denne klasse, der kan bruges andre steder i programmet
    static private final EkgController EKG_CONTROLLER_OBJ = new EkgController();

    // Returnerer det statiske objekt af denne klasse
    static public EkgController  getEkgControllerObj() {
        return EKG_CONTROLLER_OBJ;
    }

    // Indsætter et EkgSession-objekt og et EkgData-objekt i databasen ved hjælp af SQL-klassen
    public void insertPythonData(EkgSession ekgSession,EkgData ekgData){
        try {
            SQL.getSqlOBJ().insertSessionSQL(ekgSession);
            SQL.getSqlOBJ().creatDataSQL(ekgSession);
            SQL.getSqlOBJ
