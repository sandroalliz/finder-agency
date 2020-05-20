package com.sandro.test.controller;

import com.sandro.test.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/agency")
public class AgencyController {

    @Autowired
    AgencyService agencyService;


    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public ResponseEntity<List<Agency>> get(@PathVariable String latitude,
                                            @PathVariable String longitude){
        agencyService.get(latitude, longitude);

        return ResponseEntity.ok();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody AgencyDTO dto){
        return (ResponseEntity<Void>) ResponseEntity.noContent();
    }
}
