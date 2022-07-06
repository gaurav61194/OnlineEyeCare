package com.cg.onlineeyecare.service;

import com.cg.onlineeyecare.entity.User;
import com.cg.onlineeyecare.exceptions.PasswordNotMatchException;
import com.cg.onlineeyecare.exceptions.UserNotFoundException;

public interface IUserService {
	public Boolean signIn(User user) throws UserNotFoundException;
	public Boolean signOut(User user) throws UserNotFoundException;
	public User changePassword(String userName, User user) throws UserNotFoundException, PasswordNotMatchException;
}
