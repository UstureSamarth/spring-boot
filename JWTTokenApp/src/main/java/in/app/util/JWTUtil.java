package in.app.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	public static String generateToken(String id, String payload, String secreteKey) {
		return Jwts.builder().setId(id).setSubject(payload).setIssuer("MyApp")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secreteKey.getBytes())).compact();
	}

	public static Claims getClaims(String token, String secreteKey) {

		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secreteKey.getBytes())).parseClaimsJws(token)
				.getBody();

	}

	public static boolean isTokenValid(String token, String secreteKey) {
		Date tokenExpiry = getClaims(token, secreteKey).getExpiration();
		Date date = new Date();
		Boolean result = date.before(tokenExpiry);
		return result;
	}
}
