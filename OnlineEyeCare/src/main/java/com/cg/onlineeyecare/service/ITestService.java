package com.cg.onlineeyecare.service;

import java.util.List;

import com.cg.onlineeyecare.entity.TestModule;
import com.cg.onlineeyecare.exceptions.TestIdNotFoundException;

public interface ITestService {
	TestModule addTest(TestModule test);

	TestModule updateTest(TestModule test);

	TestModule removeTest(int testId)throws TestIdNotFoundException;

	TestModule viewTest(int testId)throws TestIdNotFoundException;

	List <TestModule> viewAllTests();

}
