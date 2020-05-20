package com.sandro.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AgencyService {

    void get(String latitude, String longitude);
}
