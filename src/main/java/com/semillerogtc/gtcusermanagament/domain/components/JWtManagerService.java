package com.semillerogtc.gtcusermanagament.domain.components;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class JWtManagerService {
    private String secret = "0909'??¿?";
     public String generate() {
         Map<String,Object> claims = new HashMap<String, Object>();
         claims.put("id", "1234");
         claims.put("name","Jeff");
         claims.put("role","admin");
         Date expirationDate = new Date(System.currentTimeMillis() + (1000*60));
         var jwt = Jwts.builder()
                 .setClaims(claims)
                 .setExpiration(expirationDate)
                 .signWith(SignatureAlgorithm.HS512, this.secret.getBytes())
                 .compact();
         return jwt;
     }

     public Jwt validate(String jwt) {
         var result = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwt);
         return result;
     }
}
