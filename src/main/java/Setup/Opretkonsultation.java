package Setup;
//

//@XmlRootElement
public class Opretkonsultation<nummer> {

    private String name;

    public String getName() { // Vigtigt at tilføje get() og set()
        return name;
    }

    public void setName(String Name){ this.name = Name;}

    private String Cpr;

    public String getCpr() {
        return Cpr;
    }

    public void setCpr(String Cpr) {
        this.Cpr = Cpr;
    }

    private String tidspunkt;

    public String gettidspunkt() {
        return tidspunkt;
    }

    public void settidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    private String dato;

    public String getdato() {
        return dato;
    }

    public void setdato(String dato) {
        this.dato = dato;
    }

    private String notat;

    public String getnotat() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }

    public void setNavn(String navn) {
    }
}



