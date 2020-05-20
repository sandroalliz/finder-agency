package com.sandro.finder.repository;


import com.sandro.finder.domain.Agency;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AgencyRepository {

    public List<Agency> getAgencies(String latitude, String longitude){
        //TO DO CONNECTIO WITH GOOGLE API MAPS


        //MOCK AGENCIES
        List<Agency> agencies = new ArrayList<>();
        agencies.add(new Agency(8955, "Av. Washington Luís, 1171 - Santo Amaro, São Paulo - SP, 04662-002", "10"));
        agencies.add(new Agency(8955, "Alameda Santo Amaro, Av. Adolfo Pinheiro, 478, São Paulo - SP, 04734-000", "Temporariamente Fechada  "));
        agencies.add(new Agency(8955, "Av. de Pinedo, 294 - Santo Amaro, São Paulo - SP, 04764-000", "10"));
        agencies.add(new Agency(8955, "Av. de Pinedo, 505 - Socorro, São Paulo - SP, 04764-001", "10"));
        return agencies;
    }
}
