package com.sandro.finder;

import com.sandro.finder.controller.AgencyController;
import com.sandro.finder.domain.Agency;
import com.sandro.finder.dto.DataDTO;
import com.sandro.finder.repository.DataUserRepository;
import com.sandro.finder.service.AgencyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AgencyControllerTest {

    @Mock
    private AgencyService agencyService;

    @Mock
    DataUserRepository dataUserRepository;

    @InjectMocks
    private AgencyController agencyController;

    @Test
    public void testShouldReturnAgencies() throws IOException {
        when(this.agencyService.get(anyString(), anyString())).thenReturn(getMocksAgencies());

        ResponseEntity responseEntity = this.agencyController.get("x", "x");

        assertNotNull("should not be null", responseEntity);
    }

    @Test
    public void testShouldSaveData() throws IOException {
        ResponseEntity responseEntity = this.agencyController.insert(getMockData());

        assertNotNull("should not be null", responseEntity);
    }

    private List<Agency> getMocksAgencies() {
        List<Agency> agencies = new ArrayList<>();
        agencies.add(new Agency("(11) 2628-3135", "Av. Washington Luís, 1171 - Santo Amaro, São Paulo - SP, 04662-002", "10:00"));
        agencies.add(new Agency("(11) 2628-3135", "Alameda Santo Amaro, Av. Adolfo Pinheiro, 478, São Paulo - SP, 04734-000", "Temporariamente Fechada"));
        agencies.add(new Agency("(11) 2628-3135", "Av. de Pinedo, 294 - Santo Amaro, São Paulo - SP, 04764-000", "10:30"));
        agencies.add(new Agency("(11) 2628-3135", "Av. de Pinedo, 505 - Socorro, São Paulo - SP, 04764-001", "09:00"));
        return agencies;
    }

    private DataDTO getMockData(){
        return new DataDTO("x", "x", "Android", "Chrome", "(11) 98661-2808");
    }
}
