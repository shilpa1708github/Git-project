package com.insurance.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.insurance.model.Policy;
import com.insurance.model.User;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;

public interface UserService<UserRequet> {
	
//Save User with multiple Policy,Premium and Nominee.	
	public User saveUserDetails(User user);

//Update User with multiple Policy,Premium and Nominee.	
	public UserResponse updateUser(Long id, UserRequest request);
	
//Excel file Operation	
	public void generateExcel(HttpServletResponse response) throws IOException;

	public UserResponse getUserDetails(Long id);
	// CSV file with policy
	public List<Policy> findAll(HttpServletResponse response) throws IOException;


}
