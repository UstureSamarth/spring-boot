package in.app.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestMockVsSpy {

	@Test
	public void testList() {
		ArrayList<String> listMock = Mockito.mock(ArrayList.class);
		ArrayList<String> listSpy = Mockito.spy(new ArrayList<String>());
		listMock.add("sachin");
		listSpy.add("sachin");
	}
}
