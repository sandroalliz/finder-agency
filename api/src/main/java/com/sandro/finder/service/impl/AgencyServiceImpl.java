package com.sandro.finder.service.impl;

import com.sandro.finder.domain.Agency;
import com.sandro.finder.repository.AgencyRepository;
import com.sandro.finder.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    AgencyRepository agencyRepository;

    public List<Agency> get(String latitude, String longitude) throws IOException {
        return agencyRepository.getAgencies(latitude, longitude);
    }
}
