package Controller;

import Setup.LoginData;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Calendar;

public class JWTHandler {
    private static Key key;
    private static final int TOKEN_EXPIRY = 2880; // 2 dage

    public static String generateJwtToken(LoginData user) {
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        return Jwts.builder()
                .setIssuer("GiraffeDeluxe")
                .claim("user", user)
                .signWith(SignatureAlgorithm.HS512, getKey())
                .setExpiration(expiry.getTime())
                .compact();
    }

    private static Key getKey() {
        if (key == null) {
            if (System.getenv("JWT_SECRET_KEY") != null && !System.getenv("JWT_SECRET_KEY").isEmpty()) {
                String string = System.getenv("JWT_SECRET_KEY");
                key = new SecretKeySpec(string.getBytes(), 0, string.length(), "HS512");
            } else {
                key = MacProvider.generateKey(SignatureAlgorithm.HS512);
            }
        }
        return key;
    }

    public static <User> User validate(String authentication) throws JwtException {
        String[] tokenArray = authentication.split(" ");
        String token = tokenArray[tokenArray.length - 1];
        return null;
    }
}
