package Setup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientData {



    //private List<opretkonsultation> Opretkonsultation = new ArrayList<>();
    private static PatientData instance = new PatientData();

    private PatientData() {

    }
    public static PatientData getInstance () {
        return instance;
    }



    public List<Opretkonsultation> getOpretkonsultation () throws SQLException {

        try {
            Class.forName(" ");
            String url = " ";
            String user = " ";
            String pass = " ";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM  ");
            List<Opretkonsultation> OpretkonsultationList =new ArrayList<>();
            while (rs.next()) {
                String cpr = rs.getString("cpr");
                String navn = rs.getString("navn");
                String tidspunkt = rs.getString("tidspunkt");
                String dato = rs.getString("dato");
                String notat = rs.getString("notat");

                Opretkonsultation aftale = new Opretkonsultation();
                aftale.setCpr(cpr);
                aftale.setNavn(navn);
                aftale.settidspunkt(tidspunkt);
                aftale.setNotat(notat);
                OpretkonsultationList.add(aftale);


                System.out.println(cpr);
                System.out.println(navn);
                System.out.println(tidspunkt);
                System.out.println(dato);
                System.out.println(notat);



            }
            statement.close();
            return OpretkonsultationList;
        } catch (Exception e) {
            System.err.println("Exception!");
            System.err.println(e.getMessage());

        }

        return null;

    }

    public void savekonsultation (Opretkonsultation a){
        Connection conn = null;
        Statement stmt = null;



        try {
            Class.forName(" ");
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(" ", " ", " ");
            System.out.println("Connected to database!");

            System.out.println("Table called Opretkonsultation");
            stmt = conn.createStatement();

            //vi åbner op for sql injection for at udngå dette skal man lave en pepered statment
            // for at undgår sql injektion skal der laves prepared statment hvilket filtre tegn

            String sql = "INSERT INTO Opretkonsultation (cpr, navn,tidspunkt,dato,notat) VALUES ('"+a.getCpr()+"','"+a.getName()+"','"+a.gettidspunkt()+"','"+a.getdato()+"','"+a.getnotat()+"')";

            stmt.executeUpdate(sql);


            System.out.println("Inserted, check ...");

        }catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();



        }finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch (SQLException se){

            }
            try {
                if (conn != null)
                    conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }



        }


    }

}



