package dev.rishit.vibecoder.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtUtil {

    @Value("${app.jwt.secret}")
    String secretKey;

    @Value("${app.jwt.expiration}")
    Long expirationMs;

    public SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(String  subject){
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date())
                .signWith(getSigningKey())
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTokenValid(String token, String expectedSubject) {
        String subject = extractSubject(token);
        return subject.equals(expectedSubject) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractSubject(String token) {
        return extractClaims(token).getSubject();
    }


}
