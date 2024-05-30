package com.insurance.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.exception.IdNotFoundException;
import com.insurance.model.Nominee;
import com.insurance.model.Policy;
import com.insurance.model.Premium;
import com.insurance.model.User;
import com.insurance.repository.NomineeRepository;
import com.insurance.repository.PolicyRepository;
import com.insurance.repository.PremiumRepository;
import com.insurance.repository.UserRepository;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;
import com.insurance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private NomineeRepository nomineeRepository;

	@Autowired
	private PremiumRepository premiumRepository;

	public User saveUserDetails(User user) {
		return userRepository.save(user);
	}

	@Override
	public UserResponse updateUser(Long id, UserRequest request) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not exist..!!!"));
		// Update user attributes
		UserResponse response = new UserResponse();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setMobileNumber(request.getMobileNumber());

		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setMobileNumber(user.getMobileNumber());

		user.getPolicylist().clear();
		user.getNomineelist().clear();
		user.getPremiumlist().clear();

		// Update polices
		for (Policy policy : request.getPolicylist()) {
			Optional<Policy> existingPolicy = policyRepository.findById(policy.getPolicyId());
			if (existingPolicy.isPresent()) {
				Policy updatep = existingPolicy.get();
				updatep.setPolicyName(policy.getPolicyName());
				policyRepository.save(updatep);
				response.setPolicylist(user.getPolicylist());
			} else {
				new IdNotFoundException("Policy with that is not Present");
			}
		}

		// Update Nominee
		for (Nominee nominee : request.getNomineelist()) {
			Optional<Nominee> existingNominee = nomineeRepository.findById(nominee.getNomineeid());
			if (existingNominee.isPresent()) {
				Nominee updateNominee = existingNominee.get();
				updateNominee.setNomineeName(nominee.getNomineeName());
				updateNominee.setNomineeAge(nominee.getNomineeAge());
				updateNominee.setRelation(nominee.getRelation());
				nomineeRepository.save(updateNominee);
				response.setNomineelist(user.getNomineelist());
			} else {
				new IdNotFoundException("Nominee with that is not Present");
			}
		}

		// Update Premium details
		for (Premium premium : request.getPremiumlist()) {
			Optional<Premium> existingPremiun = premiumRepository.findById(premium.getPrimiumId());
			if (existingPremiun.isPresent()) {
				Premium updatePremium = existingPremiun.get();
				updatePremium.setPaymentFrequency(premium.getPaymentFrequency());
				updatePremium.setPaymentMethod(premium.getPaymentMethod());
				premiumRepository.save(updatePremium);
				response.setPremiumlist(user.getPremiumlist());
			} else {
				new IdNotFoundException("Premium with that is not Present");
			}
		}

		userRepository.save(user);
		return response;
	}

	 @Transactional(readOnly = true)
	    public UserResponse getUserDetails(Long id) {
	        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

	        UserResponse userResponse = new UserResponse();
	        userResponse.setId(user.getId());
	        userResponse.setFirstName(user.getFirstName());
	        userResponse.setLastName(user.getLastName());
	        userResponse.setEmail(user.getEmail());
	        userResponse.setMobileNumber(user.getMobileNumber());
	        userResponse.setPolicylist(user.getPolicylist());
	        userResponse.setNomineelist(user.getNomineelist());
	        userResponse.setPremiumlist(user.getPremiumlist());

	        return userResponse;
	    }

// Excel file Operation of Policy	

	@Override
	public void generateExcel(HttpServletResponse response) throws IOException {

		List<Policy> policies = policyRepository.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Policy_info");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("policy_id");
		row.createCell(1).setCellValue("policy_name");
		row.createCell(2).setCellValue("policy_status");

		int dataRowIndex = 1;
			for (Policy p : policies) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(p.getPolicyId());
			dataRow.createCell(1).setCellValue(p.getPolicyName());
			dataRow.createCell(2).setCellValue(p.getPolicyStatus());
			dataRowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		// workbook.close();
		ops.close();
	}
	public  List<Policy> findAll(HttpServletResponse response) throws IOException
	{
		return (List<Policy>)policyRepository.findAll();
	}
	/*public void findAll() {
		// TODO Auto-generated method stub
		
*/		

	

}