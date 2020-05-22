package com.sandro.finder;

import com.sandro.finder.domain.Agency;
import com.sandro.finder.repository.AgencyRepository;
import com.sandro.finder.service.AgencyService;
import com.sandro.finder.service.impl.AgencyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AgencyServiceTest {

    @Mock
    private AgencyRepository agencyRepository;

    @InjectMocks
    private AgencyServiceImpl agencyService;

    @Test
    public void testShouldReturnAgencies() throws IOException {
        when(this.agencyRepository.getAgencies(anyString(), anyString())).thenReturn(getMocksAgencies());

        List<Agency> agencies = this.agencyService.get("x", "x");
        assertNotNull("should not be null", agencies);
    }

    private List<Agency> getMocksAgencies() {
        List<Agency> agencies = new ArrayList<>();
        agencies.add(new Agency("(11) 2628-3135", "Av. Washington Luís, 1171 - Santo Amaro, São Paulo - SP, 04662-002", "10:00"));
        agencies.add(new Agency("(11) 2628-3135", "Alameda Santo Amaro, Av. Adolfo Pinheiro, 478, São Paulo - SP, 04734-000", "Temporariamente Fechada"));
        agencies.add(new Agency("(11) 2628-3135", "Av. de Pinedo, 294 - Santo Amaro, São Paulo - SP, 04764-000", "10:30"));
        agencies.add(new Agency("(11) 2628-3135", "Av. de Pinedo, 505 - Socorro, São Paulo - SP, 04764-001", "09:00"));
        return agencies;
    }
}
