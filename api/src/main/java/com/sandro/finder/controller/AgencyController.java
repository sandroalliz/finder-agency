package com.sandro.finder.controller;

import com.sandro.finder.domain.Agency;
import com.sandro.finder.domain.DataUser;
import com.sandro.finder.dto.DataDTO;
import com.sandro.finder.repository.DataUserRepository;
import com.sandro.finder.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/agency")
public class AgencyController {

    @Autowired
    AgencyService agencyService;

    @Autowired
    DataUserRepository dataUserRepository;

    @CrossOrigin
    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public ResponseEntity<List<Agency>> get(@PathVariable String latitude,
                                            @PathVariable String longitude){

        List<Agency> agencies = agencyService.get(latitude, longitude);
        return ResponseEntity.ok(agencies);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody DataDTO dto){

        dataUserRepository.save(new DataUser(dto));
        return ResponseEntity.noContent().build();
    }
}
