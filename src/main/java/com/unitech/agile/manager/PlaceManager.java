package com.unitech.agile.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.unitech.agile.dto.ConvenienceDTO;
import com.unitech.agile.dto.OpinionDTO;
import com.unitech.agile.dto.PlaceDTO;
import com.unitech.agile.dto.PlaceTypeDTO;
import com.unitech.agile.entity.Convenience;
import com.unitech.agile.entity.Opinion;
import com.unitech.agile.entity.Place;
import com.unitech.agile.entity.PlaceConvenience;
import com.unitech.agile.entity.PlaceType;
import com.unitech.agile.entity.UserSession;
import com.unitech.agile.model.response.BaseArrayResponse;
import com.unitech.agile.model.response.BaseObjectResponse;
import com.unitech.agile.model.response.PlaceDetailsResponse;
import com.unitech.agile.repository.ConvenienceRepository;
import com.unitech.agile.repository.OpinionRepository;
import com.unitech.agile.repository.PlaceConvenienceRepository;
import com.unitech.agile.repository.PlaceRepository;
import com.unitech.agile.repository.PlaceTypeRepository;
import com.unitech.agile.repository.UserSessionRepository;

@Service
public class PlaceManager {
	
	private static final long DAY_IN_MILIS = 86_400_000;
	private static final long WEEK_IN_MILIS = 604_800_000;
	private static final long TWO_WEEKS_IN_MILIS = 1_209_600_000;

	@Autowired
	PlaceRepository placeRepository;
	
	@Autowired
	PlaceConvenienceRepository placeConvenienceRepository;

	@Autowired
	ConvenienceRepository convenienceRepository;
	
	@Autowired
	UserSessionRepository userSessionRepository;
	
	@Autowired
	PlaceTypeRepository placeTypeRepository;
	
	@Autowired
	OpinionRepository opinionRepository;
	
	public BaseArrayResponse<PlaceDTO> getPlaces(String token) {
		final BaseArrayResponse<PlaceDTO> response = new BaseArrayResponse<PlaceDTO>();
		final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
//		if(!CommonTools.isSessionValid(session)) {
//			response.setCode(2);
//			response.setMessage("Session is not valid");
//			return response;
//		}
		
		final List<Place> places = placeRepository.findAllValid();
		final List<PlaceDTO> dto = new ArrayList<>();
		for(Place p : places) {
			final List<PlaceConvenience> placeConveniences = placeConvenienceRepository.findByPlaceId(p.getId());
			final List<ConvenienceDTO> conveniences = new ArrayList<>();
			for(PlaceConvenience pc : placeConveniences) {
				final Convenience c = convenienceRepository.findById(pc.getConvenience().getId());
				conveniences.add(new ConvenienceDTO(c.getId(), c.getName()));
			}
			
			final PlaceType placeType = placeTypeRepository.findById(p.getPlaceType().getId());
			final PlaceTypeDTO placeTypeDTO = new PlaceTypeDTO(placeType.getId(), placeType.getName());
			
			dto.add(new PlaceDTO(p.getId(), p.getName(), p.getLat(), p.getLon(), placeTypeDTO));
		}
		response.setResponse(dto);
		response.setCode(1);
		response.setMessage("OK");
		return response;
	}
	
	public BaseObjectResponse<PlaceDetailsResponse> getPlaceDetails(String token, int id) {
		final BaseObjectResponse<PlaceDetailsResponse> response = new BaseObjectResponse<PlaceDetailsResponse>();
		final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
//		if(!CommonTools.isSessionValid(session)) {
//			response.setCode(2);
//			response.setMessage("Session is not valid");
//			return response;
//		}
		
		final Place place = placeRepository.findById(id);
		if(place == null) {
			response.setCode(2);
			response.setMessage("Invalid id");
		} else {
			final List<PlaceConvenience> placeConveniences = placeConvenienceRepository.findByPlaceId(place.getId());
			final List<ConvenienceDTO> conveniences = new ArrayList<>();
			for(PlaceConvenience pc : placeConveniences) {
				final Convenience c = convenienceRepository.findById(pc.getConvenience().getId());
				conveniences.add(new ConvenienceDTO(c.getId(), c.getName()));
			}
			
			final PlaceType placeType = placeTypeRepository.findById(place.getPlaceType().getId());
			final PlaceTypeDTO placeTypeDTO = new PlaceTypeDTO(placeType.getId(), placeType.getName());
			
			final List<Opinion> opinions = opinionRepository.findByPlaceId(place.getId());
			final List<OpinionDTO> opinionsDTO = new ArrayList<>();
			for(Opinion o : opinions) {
				opinionsDTO.add(new OpinionDTO(o.getComment()));
			}
			
			final PlaceDetailsResponse placeDetailsResponse = new PlaceDetailsResponse(place.getId(), place.getName(),
					place.getLat(), place.getLon(), place.getDescription(), place.getAddress(), conveniences, placeTypeDTO,
					opinionsDTO, calculateRating(opinions), opinionsDTO.size());
			response.setResponse(placeDetailsResponse);
			response.setCode(1);
			response.setMessage("OK");
		}
		return response;
	}
	
	private float calculateRating(List<Opinion> opinions) {
		if(opinions.size() == 0) {
			return 0.0f;
		}
		double sum = 0.0;
		double count = 0.0;
		for(Opinion o : opinions) {
			final long diff = System.currentTimeMillis() - o.getAddDate().getTime();
			if(diff >= TWO_WEEKS_IN_MILIS) {
				sum += o.getRating() * 0.4;
				count += 0.4;
			} else if(diff >= WEEK_IN_MILIS) {
				sum += o.getRating() * 0.6;
				count += 0.6;
			} else if(diff >= DAY_IN_MILIS) {
				sum += o.getRating() * 0.8;
				count += 0.8;
			} else {
				sum += o.getRating();
				count += 1.0;
			}
		}
		return (float)(sum / count);
	}
}
