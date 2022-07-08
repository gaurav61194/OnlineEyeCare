package com.cg.onlineeyecare.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyecare.dao.ITestRepository;
import com.cg.onlineeyecare.entity.TestModule;
import com.cg.onlineeyecare.exceptions.TestIdNotFoundException;

@Service
public class ITestServiceImpl implements ITestService {

	@Autowired
	private ITestRepository repository;


	@Override
	public TestModule addTest(TestModule test) {
		return repository.saveAndFlush(test);
	}

	@Override
	public TestModule updateTest(TestModule test) {
		return repository.saveAndFlush(test);

	}


	@Override
	public TestModule removeTest(int testId) throws TestIdNotFoundException {
		Optional<TestModule> test =repository.findById(testId);

		if(test.isPresent()) {
			repository.deleteById(testId);
			return test.get();
		}
		else
		{
			throw new TestIdNotFoundException("Please Enter the id which is available in database");
		}
	}

	@Override
	public TestModule viewTest(int testId)throws TestIdNotFoundException {
		Optional<TestModule> test =repository.findById(testId);
		if(test.isPresent()) {
			return test.get();
		}
		else
		{
			throw new TestIdNotFoundException("Please Enter the id which is available in database");
		}

	}
	@Override
	public List<TestModule> viewAllTests() {

		return repository.findAll();
	}

}
