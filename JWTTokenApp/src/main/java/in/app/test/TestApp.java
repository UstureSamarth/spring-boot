package in.app.test;

import java.io.IOException;

import in.app.util.JWTUtil;
import io.jsonwebtoken.Claims;

public class TestApp {

	public static void main(String[] args) throws IOException {
		String token=JWTUtil.generateToken("123", "Samarth Usture","ssdd" );
		System.out.println(token);
		
		Claims body=JWTUtil.getClaims(token, "ssdd");
		System.out.println(body.getSubject());
		System.out.println(body.getId());
		System.out.println(body.getIssuer());
		System.out.println(body.getExpiration());
		System.out.println(body.getIssuedAt());
		System.in.read();
		System.out.println(JWTUtil.isTokenValid(token, "ssdd"));
	}
}
