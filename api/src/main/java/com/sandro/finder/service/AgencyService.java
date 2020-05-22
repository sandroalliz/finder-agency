package com.sandro.finder.service;

import com.sandro.finder.domain.Agency;

import java.io.IOException;
import java.util.List;

public interface AgencyService {

    List<Agency> get(String latitude, String longitude) throws IOException;
}
