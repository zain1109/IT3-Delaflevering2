package api;

import controller.JWTHandler;
import model.User;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        // Tjekker om der findes en authorization header
        if (containerRequestContext.getHeaderString("Authorization") == null) {
            throw new WebApplicationException("Ingen Token", 401);
        }

        // Tjekker om stien kræver en privat nøgle
        if ("aftaler".equals(containerRequestContext.getUriInfo().getPath()) ||
                "ekgSessions".equals(containerRequestContext.getUriInfo().getPath()) ||
                "ekgSessions/measurements".equals(containerRequestContext.getUriInfo().getPath())) {
            // Kaster en exception hvis authorization headeren ikke matcher den forventede privat nøgle
            if (!containerRequestContext.getHeaderString("Authorization").equals("Bearer hemmeliglogin")) {
                throw new WebApplicationException("Forkert Login", 401);
            }
        }
        else {
            // Validerer JWT-tokenet og gemmer brugerobjektet i request context'en hvis tokenet er gyldigt
            try {
                User user = JWTHandler.validate(containerRequestContext.getHeaderString("Authorization"));
                containerRequestContext.setProperty("user",user);
            } catch (Exception e) {
                throw new WebApplicationException("Invalid Token", 401);
            }
        }
    }
}