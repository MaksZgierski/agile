package com.unitech.agile.manager;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitech.agile.entity.ApplicationUser;
import com.unitech.agile.entity.UserType;
import com.unitech.agile.model.request.RegisterUserRequest;
import com.unitech.agile.model.response.BaseObjectResponse;
import com.unitech.agile.repository.ApplicationUserRepository;
import com.unitech.agile.repository.UserTypeRepository;
import com.unitech.agile.tools.CommonTools;

@Service
public class RegisterUserManager {

	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	UserTypeRepository userTypeRepository;
	
	@SuppressWarnings("rawtypes")
	public BaseObjectResponse registerUser(RegisterUserRequest request) {
		final BaseObjectResponse response = new BaseObjectResponse();
		if(StringUtils.isBlank(request.getLogin()) || StringUtils.isBlank(request.getPassword()) || StringUtils.isBlank(request.getName())) {
			response.setCode(2);
			response.setMessage("Some of the required fields are empty");
			return response;
		}
		final UserType userType = userTypeRepository.findById(1);
		final ApplicationUser check = applicationUserRepository.findByLogin(request.getLogin());
		if(check != null) {
			response.setCode(2);
			response.setMessage("This login is already used");
		} else {
			final ApplicationUser user = new ApplicationUser();
			user.setLogin(request.getLogin());
			user.setPassword(CommonTools.generateMD5(request.getPassword()));
			user.setName(request.getName());
			user.setActive(true);
			user.setUserType(userType);
			user.setAddDate(new Timestamp(System.currentTimeMillis()));
			applicationUserRepository.save(user);
			
			response.setCode(1);
			response.setMessage("OK");
		}
		return response;
	}
}
