package com.insurance.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;
import com.insurance.model.Policy;
import com.insurance.model.User;
import com.insurance.repository.UserRepository;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;
import com.insurance.service.UserService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository repository;

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUserInsuranceDetails(@RequestBody User user) {
		User user1 = userService.saveUserDetails(user);
		return ResponseEntity.ok().body(user1);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserResponse> updateUserw(@PathVariable Long id, @RequestBody UserRequest request) {
		UserResponse userResponse = userService.updateUser(id, request);
		return ResponseEntity.ok().body(userResponse);
	}

	@GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserDetails(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserDetails(id);
        return ResponseEntity.ok().body(userResponse);
}


// API for create excel file and restore policy details.
		@GetMapping("/excel")
		public void generateExcelReport(HttpServletResponse response) throws IOException {
			response.setContentType("application/octet-stream");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment;filename=policydetails.xls";
			response.setHeader(headerKey, headerValue);
			userService.generateExcel(response);
		}
		
		
	// API for create CSV file and save policy details  
		@GetMapping("/csvfile")
		public void exportCsvFile(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
	// set filename and content type
			
		String filename="Policy-Details.csv";
		response.setContentType("txt/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\" " + filename + "\"" );
		
		// create csv writer

		StatefulBeanToCsv <Policy> writer = new StatefulBeanToCsvBuilder<Policy>(response.getWriter())
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false).build();
		
		writer.write(userService.findAll(response));

		}



}
