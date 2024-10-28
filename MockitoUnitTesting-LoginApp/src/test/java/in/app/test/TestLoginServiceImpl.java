package in.app.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import in.app.dao.ILoginDao;
import in.app.service.ILoginService;
import in.app.service.LoginServiceImpl;

public class TestLoginServiceImpl {

	private static ILoginService service;
	private static ILoginDao mockDao;

	@BeforeAll
	public static void setUpOnce() {
		mockDao = Mockito.mock(ILoginDao.class);
		service = new LoginServiceImpl(mockDao);
	}

	@Test
	public void testLoginWithValidCredentials() throws Exception {

		Mockito.when(mockDao.authenticate("sachin", "tendulkar")).thenReturn(1);
		Boolean actual = service.login("sachin", "tendulkar");
		assertTrue(actual);
	}

	@Test
	public void testLoginWithInvalidCredentials() throws Exception {

		Mockito.when(mockDao.authenticate("sachin", "tendkar")).thenReturn(0);
		Boolean actual = service.login("sachin", "tendkar");
		assertFalse(actual);
	}

	@Test
	public void testLoginWithNoCredentials() {
		assertThrows(IllegalArgumentException.class, () -> service.login("", ""));
	}

	@AfterAll
	public static void clearUpOnce() {
		mockDao = null;
		service = null;
	}
}
