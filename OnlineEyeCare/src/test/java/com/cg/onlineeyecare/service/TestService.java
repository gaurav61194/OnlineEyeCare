package com.cg.onlineeyecare.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.onlineeyecare.entity.TestModule;
import com.cg.onlineeyecare.exceptions.TestIdNotFoundException;

@SpringBootTest
public class TestService {
	@Autowired
	ITestService service;

	@Test
	void addtest() throws TestIdNotFoundException {
		TestModule ts2 = new TestModule(110, "Vision", "Eye Swelling", "X-ray", 500);
		service.addTest(ts2);
		assertEquals("X-ray", service.viewTest(110).getTestDescription());
	}

	@Test
	void romovetest() throws TestIdNotFoundException {
		assertEquals(110, service.removeTest(110).getTestId());
	}

	@Test
	void viewtest() throws TestIdNotFoundException {
		assertEquals("Retinoscopy", service.viewTest(126).getTestName());
	}

}
