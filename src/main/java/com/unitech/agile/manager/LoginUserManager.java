package com.unitech.agile.manager;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitech.agile.entity.ApplicationUser;
import com.unitech.agile.entity.UserSession;
import com.unitech.agile.model.request.LoginUserRequest;
import com.unitech.agile.model.response.BaseObjectResponse;
import com.unitech.agile.model.response.LoginUserResponse;
import com.unitech.agile.repository.ApplicationUserRepository;
import com.unitech.agile.repository.UserSessionRepository;
import com.unitech.agile.tools.CommonTools;

@Service
public class LoginUserManager {

	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	UserSessionRepository userSessionRepository;
	
	public BaseObjectResponse<LoginUserResponse> login(LoginUserRequest request) {
		final ApplicationUser user = applicationUserRepository.findByLoginAndPassword(request.getLogin(), CommonTools.generateMD5(request.getPassword()));
		final BaseObjectResponse<LoginUserResponse> response = new BaseObjectResponse<LoginUserResponse>();
		if(user != null) {
			final UserSession session = new UserSession();
			session.setApplicationUser(user);
			final String token = CommonTools.generateSessionToken();
			session.setToken(token);
			session.setAddDate(new Timestamp(System.currentTimeMillis()));
			userSessionRepository.save(session);
			
			final LoginUserResponse loginUserResponse = new LoginUserResponse(token);
			response.setCode(1);
			response.setMessage("OK");
			response.setResponse(loginUserResponse);
		} else {
			response.setCode(2);
			response.setMessage("Credentials are incorrect");
		}
		
		return response;
	}
}
