package com.unitech.agile.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.unitech.agile.dto.PlaceTypeDTO;
import com.unitech.agile.entity.PlaceType;
import com.unitech.agile.entity.UserSession;
import com.unitech.agile.model.response.BaseArrayResponse;
import com.unitech.agile.repository.PlaceTypeRepository;
import com.unitech.agile.repository.UserSessionRepository;
import com.unitech.agile.tools.CommonTools;

@Service
public class PlaceTypeManager {

	@Autowired
	PlaceTypeRepository placeTypeRepository;
	
	@Autowired
	UserSessionRepository userSessionRepository;
	
	public BaseArrayResponse<PlaceTypeDTO> getPlaceTypes(String token) {
		final BaseArrayResponse<PlaceTypeDTO> response = new BaseArrayResponse<PlaceTypeDTO>();
		final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
		if(!CommonTools.isSessionValid(session)) {
			response.setCode(2);
			response.setMessage("Session is not valid");
			return response;
		}
		
		final List<PlaceType> placeTypes = placeTypeRepository.findAllValid();
		final List<PlaceTypeDTO> dto = new ArrayList<>();
		for(PlaceType pt : placeTypes) {
			dto.add(new PlaceTypeDTO(pt.getId(), pt.getName()));
		}
		response.setResponse(dto);
		response.setCode(1);
		response.setMessage("OK");
		return response;
	}
}
