package org.kshrdcenter.spring_homework003.service.impl;

import org.kshrdcenter.spring_homework003.exception.NotFoundException;
import org.kshrdcenter.spring_homework003.model.dto.request.VenueRequest;
import org.kshrdcenter.spring_homework003.model.entity.Venue;
import org.kshrdcenter.spring_homework003.repository.VenueRepository;
import org.kshrdcenter.spring_homework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenue(Integer page, Integer size) {
        page = (page - 1) * size;
        return venueRepository.getAllVenue(page, size);
    }

    @Override
    public Venue saveVenue(VenueRequest request) {
        return venueRepository.saveVenue(request);
    }

    @Override
    public Venue getVenueById(Long venueId) {
        if (venueRepository.getVenueById(venueId) == null) {
            throw new NotFoundException("Cannot find venue with id " + venueId + " !");
        }
        return venueRepository.getVenueById(venueId);
    }

    @Override
    public Venue updateVenueById(Long venueId, VenueRequest request) {
        if (venueRepository.getVenueById(venueId) == null) {
            throw new NotFoundException("Cannot find venue with id " + venueId + " !");
        }
        return venueRepository.updateVenueById(venueId, request);
    }

    @Override
    public Venue deleteVenueById(Long venueId) {
        if (venueRepository.getVenueById(venueId) == null) {
            throw new NotFoundException("Cannot find venue with id " + venueId + " !");
        }
        return venueRepository.deleteVenueById(venueId);
    }


}