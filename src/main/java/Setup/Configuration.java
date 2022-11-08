package Setup;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest") // Skal angive applikationen
                         // Adresse giver adgang til api

public class Configuration extends Application {
}

