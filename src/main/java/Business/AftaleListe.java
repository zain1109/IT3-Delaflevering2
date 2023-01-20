package Business;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Aftaleliste")
public class AftaleListe {
    public <AftaleData> List<AftaleData> getAftaler() {
        String Aftaler = null;
        System.out.println("AftaleListe: " + null);
       // return (List<AftaleData>) Aftaler;
        return null;
    }


    public <AftaleData> void setAftaler(List<AftaleData> aftaler) {
        List<AftaleData> Aftaler = aftaler;
    }

  /*  @XmlElement
    List<AftaleData> Aftaler = new ArrayList<>();
  */
}