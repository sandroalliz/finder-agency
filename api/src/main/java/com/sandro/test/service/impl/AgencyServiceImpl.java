package com.sandro.test.service.impl;

import com.sandro.test.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;

public class AgencyServiceImpl implements AgencyService {

    @Autowired
    AgencyRepository agencyRepository;

    public void get(String latitude, String longitude) {
    }
}
