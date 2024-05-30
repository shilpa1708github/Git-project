package com.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.insurance.repository.PolicyRepository;

@SpringBootApplication
public class InsuranceProject9Application implements CommandLineRunner {

	@Autowired
	private PolicyRepository policyRepository;
	public static void main(String[] args) {
		SpringApplication.run(InsuranceProject9Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		/*List<String> policy = new ArrayList<String>();
		
		
		
		policy.add("policyId");
		policy.add("policyName");
		policy.add("policyStatus");
*/
		policyRepository.findAll();
	}


}
