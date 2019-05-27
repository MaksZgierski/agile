package com.unitech.agile.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.unitech.agile.entity.Media;
import com.unitech.agile.entity.Place;
import com.unitech.agile.entity.UserSession;
import com.unitech.agile.model.request.AddImageRequest;
import com.unitech.agile.model.response.BaseObjectResponse;
import com.unitech.agile.repository.MediaRepository;
import com.unitech.agile.repository.PlaceRepository;
import com.unitech.agile.repository.UserSessionRepository;
import com.unitech.agile.tools.CommonTools;

@Service
public class MediaManager {
	
	private static final String IMAGE_PREFIX = "/home/maks/java_apps/agile/images/";
	
	@Autowired
	UserSessionRepository userSessionRepository;
	
	@Autowired
	PlaceRepository placeRepository;
	
	@Autowired
	MediaRepository mediaRepository;

	@SuppressWarnings("rawtypes")
	public BaseObjectResponse addImage(String token, AddImageRequest request) {
		final BaseObjectResponse response = new BaseObjectResponse();
		final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
		if(!CommonTools.isSessionValid(session)) {
			response.setCode(2);
			response.setMessage("Session is not valid");
			return response;
		}
		
		if(request.getPlaceId() == null) {
			response.setCode(2);
			response.setMessage("No place ID specified");
			return response;
		}
		if(StringUtils.isBlank(request.getImageData())) {
			response.setCode(2);
			response.setMessage("No image data");
			return response;
		}
		
		final Place place = placeRepository.findById(request.getPlaceId());
		if(place == null) {
			response.setCode(2);
			response.setMessage("Place with given ID not found");
			return response;
		}
		
		final byte[] imageData = CommonTools.convertBase64ToBytes(request.getImageData());
		if(imageData == null) {
			response.setCode(2);
			response.setMessage("Error while converting image");
			return response;
		}
		final String filename = "image" + Long.toString(System.currentTimeMillis());
		
		try (OutputStream stream = new FileOutputStream(IMAGE_PREFIX + filename)) {
		    stream.write(imageData);
		} catch(Exception e) {
			response.setCode(2);
			response.setMessage("Error while saving image");
			return response;
		}
		
		final Media media = new Media();
		media.setActive(true);
		media.setAddDate(new Timestamp(System.currentTimeMillis()));
		media.setLocalLink(filename);
		media.setPlace(place);
		mediaRepository.save(media);
		
		response.setCode(1);
		response.setMessage("OK");
		return response;
	}
	
	public File loadImage(String token, int imageId) {
		final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
		if(!CommonTools.isSessionValid(session)) {
			return null;
		}
		
		final Media media = mediaRepository.findOne(imageId);
		if(media == null) {
			return null;
		}
		return new File(IMAGE_PREFIX + media.getLocalLink());
	}
}
