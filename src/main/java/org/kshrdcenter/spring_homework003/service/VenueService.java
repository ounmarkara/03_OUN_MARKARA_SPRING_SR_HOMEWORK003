package org.kshrdcenter.spring_homework003.service;


import org.kshrdcenter.spring_homework003.model.dto.request.VenueRequest;
import org.kshrdcenter.spring_homework003.model.entity.Venue;
import org.kshrdcenter.spring_homework003.repository.VenueRepository;

import java.util.List;

public interface VenueService {


    List<Venue> getAllVenue(Integer page, Integer size);

    Venue saveVenue(VenueRequest request);

    Venue getVenueById(Integer venueId);


    Venue updateVenueById(Integer venueId, VenueRequest request);

    Venue deleteVenueById(Integer venueId);
}
