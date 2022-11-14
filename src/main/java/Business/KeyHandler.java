package Business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import Setup.LoginData;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.NotAuthorizedException;
import java.security.Key;
import java.util.Calendar;
import java.util.stream.DoubleStream;


public class KeyHandler {

    private static Key key; //Her opretter vi en private key
    private static final int TOKEN_EXPIRY = 2880; //2 dage, overlevelsestiden på vores token

    public static String generateJwtToken(LoginData user){ //
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        DoubleStream Jwts = null;
        return Jwts.builder()
                .setIssuer("test")
                .claim("user", user.getUsername()) //data
                .signWith(SignatureAlgorithm.HS512, getKey()) //Signatur
                .setExpiration(expiry.getTime())
                .compact();
    }



    private static Key getKey(){ //Her generer serveren en krypteret JWT med en hemmelige nøgle og tilbagesender til klienten
        //der bruges en hemmelige nøgle til at signere token

        if (key==null) {
            if (System.getenv("JWT_SECRET_KEY")!= null && System.getenv("JWT_SECRET_KEY") != "") {
                String string = System.getenv("JWT_SECRET_KEY");
                key = new SecretKeySpec(string.getBytes(), 0, string.length(), "HS512");
            } else {
                key = MacProvider.generateKey(SignatureAlgorithm.HS512);
            }
        }
        return key;
    }
    // Her valideres Token
    public static String validate(String authentication) {
        String[] tokenArray = authentication.split(" ");
        String token = tokenArray[tokenArray.length - 1];
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getKey())
                    .parseClaimsJws(token)
                    .getBody();
            String user = claims.get("user", String.class);
            System.out.println(user);
            return user;
        } catch (JwtException e){
            System.out.println(e.getClass() +":  "+ e.getMessage() );
            throw new NotAuthorizedException(e.getMessage());
        }
    }



}




