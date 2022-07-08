package com.cg.onlineeyecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineeyecare.entity.TestModule;
import com.cg.onlineeyecare.exceptions.TestIdNotFoundException;
import com.cg.onlineeyecare.service.ITestService;

@RestController
@RequestMapping("/onlineeyecare")
public class ITestController {

	@Autowired
	public ITestService tservice;
	
    //get all tests
	@GetMapping("/alltests")
	public List<TestModule> viewAllTests(){
		return tservice.viewAllTests();
	}

	//create tests
	@PostMapping("/test/add")
	public TestModule add(@RequestBody TestModule test)  {
		return tservice.addTest(test);
	}

	//update test
	@PutMapping("/update")
	public TestModule updateTest(@RequestBody TestModule test) {
		return tservice.updateTest(test);
	}

	//delete test by id
	@DeleteMapping("/test/delete/{testid}")  
	public TestModule removeTest(@PathVariable ("testid")int testId) throws TestIdNotFoundException  {
		return tservice.removeTest(testId);
	}

	//get test by id
	@GetMapping("/test/viewtest/{testid}") 
	private TestModule viewTest(@PathVariable("testid") int testid) throws TestIdNotFoundException  {  
		return tservice.viewTest(testid);
	}
}
