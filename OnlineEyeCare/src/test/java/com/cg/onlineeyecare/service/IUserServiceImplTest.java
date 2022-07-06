package com.cg.onlineeyecare.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.cg.onlineeyecare.entity.User;
import com.cg.onlineeyecare.exceptions.PasswordNotMatchException;
import com.cg.onlineeyecare.exceptions.UserNotFoundException;

@SpringBootTest
class IUserServiceImplTest {
	
	@Autowired
	private IUserService userService;
	User user= new User("saiteja@123","saireddy76","Doctor");
	User user1= new User("saiteja","tejas94","Doctor");
	User user2=new User("nishanth@123","nishanth21","patient");
	User user3=new User("aravind@34","avi1227","patient");
	User user4=new User("vamsi89","krishna21","patient");
	User user5=new User("manojan321","manojan4","eyespecialist");

	@Test
	void testchangePassword() throws UserNotFoundException, PasswordNotMatchException {
		user=new User("saiteja@123","saireddy76","Doctor");
		
		assertEquals("saireddy76",userService.changePassword("saiteja@123",user).getPassword());
	}
	
	@Test
	void testSignIn1() throws UserNotFoundException {
		assertTrue(userService.signIn(user));
	}

	@Test
	void testSignOut2() throws UserNotFoundException {
		assertTrue(userService.signOut(user));
	}

	@Test
	void testChangePassword1() throws UserNotFoundException,PasswordNotMatchException {
		user=new User("saiteja","tejas94","Doctor");
		assertEquals("tejas94",userService.changePassword("saiteja",user1).getPassword());
		
	}

	@Test
	void testSignIn2() throws UserNotFoundException {
		assertTrue(userService.signIn(user2));
	}
	
	@Test
	void testsignOut3() throws UserNotFoundException {
		assertTrue(userService.signOut(user1));
	}
	
	@Test
	void testchangePassword2() throws UserNotFoundException,PasswordNotMatchException {
		user2=new User("nishanth@123","nishanth21","patient");
		assertEquals("nishanth21",userService.changePassword("nishanth@123",user2).getPassword());
	}
	
	@Test
	void testSignIn3() throws UserNotFoundException {
		assertTrue(userService.signIn(user2));
	}
	
	@Test
	void testsignOut4() throws UserNotFoundException {
		assertTrue(userService.signOut(user2));
	}
	
	@Test
	void testchangePassword3() throws UserNotFoundException,PasswordNotMatchException {
		user3=new User("aravind@34","avi1227","patient");
		assertEquals("avi1227",userService.changePassword("aravind@34",user3).getPassword());
	}
	
	@Test
	void testSignIn4() throws UserNotFoundException {
		assertTrue(userService.signIn(user3));
	}
	
	@Test
	void testsignOut5() throws UserNotFoundException {
		assertTrue(userService.signOut(user3));
	}
	
	@Test
	void testchangePassword4() throws UserNotFoundException,PasswordNotMatchException {
		user4=new User("vamsi89","krishna21","patient");
		assertEquals("krishna21",userService.changePassword("vamsi89",user4).getPassword());
	}
	
	@Test
	void testSignIn5() throws UserNotFoundException {
		assertTrue(userService.signIn(user4));
	}
	
	@Test
	void testsignOut6() throws UserNotFoundException {
		assertTrue(userService.signOut(user4));
	}
	
}
