package com.unitech.agile.manager;

import com.unitech.agile.entity.ApplicationUser;
import com.unitech.agile.entity.Opinion;
import com.unitech.agile.entity.Place;
import com.unitech.agile.entity.UserSession;
import com.unitech.agile.model.request.AddOpinionRequest;
import com.unitech.agile.model.request.RateOpinionRequest;
import com.unitech.agile.model.response.BaseObjectResponse;
import com.unitech.agile.repository.ApplicationUserRepository;
import com.unitech.agile.repository.OpinionRepository;
import com.unitech.agile.repository.PlaceRepository;
import com.unitech.agile.repository.UserSessionRepository;
import com.unitech.agile.tools.CommonTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OpinionManager {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    UserSessionRepository userSessionRepository;

    @Autowired
    OpinionRepository opinionRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @SuppressWarnings("rawtypes")
    public BaseObjectResponse addOpinion(String token, AddOpinionRequest request) {
        final BaseObjectResponse response = new BaseObjectResponse();
        final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
        if (!CommonTools.isSessionValid(session)) {
            response.setCode(2);
            response.setMessage("Session is not valid");
            return response;
        }

        if (StringUtils.isBlank(request.getComment()) || request.getPlaceId() == null || request.getRating() == null) {
            response.setCode(2);
            response.setMessage("Some of the required fields are empty");
            return response;
        }

        final Place place = placeRepository.findById(request.getPlaceId());
        if (place == null) {
            response.setCode(2);
            response.setMessage("Invalid place id");
        }

        final ApplicationUser user = applicationUserRepository.findById(session.getApplicationUser().getId());
        final Opinion opinion = new Opinion();
        opinion.setAddDate(new Timestamp(System.currentTimeMillis()));
        opinion.setApplicationUser(user);
        opinion.setComment(request.getComment());
        opinion.setPlace(place);
        opinion.setRating(request.getRating());
        opinionRepository.save(opinion);

        response.setCode(1);
        response.setMessage("OK");
        return response;
    }

    public BaseObjectResponse rateOpinion(String token, RateOpinionRequest request) {
        final BaseObjectResponse response = new BaseObjectResponse();
        final UserSession session = userSessionRepository.findByToken(token, new Sort(Sort.Direction.DESC, "addDate"));
        if (!CommonTools.isSessionValid(session)) {
            response.setCode(2);
            response.setMessage("Session is not valid");
            return response;
        }

        if (request.getOpinionId() == null || request.getRating() == null) {
            response.setCode(2);
            response.setMessage("Some of the required fields are empty");
            return response;
        }

        final Opinion opinion = opinionRepository.findById(request.getOpinionId());
        if (opinion == null) {
            response.setCode(2);
            response.setMessage("Invalid opinion id");
        }
        opinion.setRating(opinion.getRating() + request.getRating());
        opinion.addCantrate(applicationUserRepository.findById(session.getApplicationUser().getId()));
        opinionRepository.save(opinion);
        response.setCode(1);
        response.setMessage("OK");
        return response;
    }
}
