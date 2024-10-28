package in.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTest {

	private static WebConversation conversation = null;
	private final static String url = "http://localhost:1990/HttpUnitLoginApp/index.html";

	@BeforeAll
	public static void setUpOnce() {
		conversation = new WebConversation();
	}

	@Test
	@DisplayName("Test With Valid Credentials")
	public void testWithValidCredentials() throws IOException, SAXException {
		WebResponse response =conversation.getResponse(url);
		WebForm form =response.getForms()[0];
		form.setParameter("uname", "sachin");
		form.setParameter("password", "tendulkar");
		WebResponse actualResponse=form.submit();
		String output=actualResponse.getText().trim();
		assertEquals("Valid Credentials", output);
		
	}

	@Test
	@DisplayName("Test With Invalid Credentials")
	public void testWithInvalidCredentials() throws IOException, SAXException {
		WebResponse response =conversation.getResponse(url);
		WebForm form =response.getForms()[0];
		form.setParameter("uname", "sachin");
		form.setParameter("password", "kar");
		WebResponse actualResponse=form.submit();
		String output=actualResponse.getText().trim();
		assertEquals("Invalid Credentials", output);
	}

	@Test
	@DisplayName("Test With No Credentials")
	public void testWithNoCredentials() throws IOException, SAXException {
		WebResponse response =conversation.getResponse(url);
		WebForm form =response.getForms()[0];
		form.setParameter("uname", "sachin");
		form.setParameter("password", "");
		WebResponse actualResponse=form.submit();
		String output=actualResponse.getText().trim();
		assertEquals("Provide Credentials", output);
	}

	@AfterAll
	public static void cleanUp() {
		conversation = null;
	}
}
