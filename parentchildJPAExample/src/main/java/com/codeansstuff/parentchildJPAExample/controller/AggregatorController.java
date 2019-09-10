package com.codeansstuff.parentchildJPAExample.controller;

import com.codeansstuff.parentchildJPAExample.dtos.AggregatorSearchRequest;
import com.codeansstuff.parentchildJPAExample.dtos.AggregatorsDTO;
import com.codeansstuff.parentchildJPAExample.entity.Aggregators;
import com.codeansstuff.parentchildJPAExample.repositories.AggregatorRepo;
import com.codeansstuff.parentchildJPAExample.repositories.AggregatorsSpecification;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author MalkeithSingh on 09-09-2019
 */

@RestController
@RequestMapping("/api/aggregators")
public class AggregatorController {

    @Autowired
    private AggregatorRepo repo;

    @GetMapping("/")
    public ResponseEntity<?> getAllAggregators() {
        return ResponseEntity.ok(repo.findAll().stream().map(mapper).collect(Collectors.toList()));
    }

    @PostMapping("/")
    public ResponseEntity<?> searchAggregators(@RequestBody AggregatorSearchRequest request) {
        return ResponseEntity.ok(repo.findAll(AggregatorsSpecification.searchInAgg(request)).stream().map(mapper).collect(Collectors.toList()));
    }

    private Function<Aggregators, AggregatorsDTO> mapper = agg -> AggregatorsDTO.builder().aggId(agg.getAggId())
            .aggKey(agg.getAggKey()).aggValue(agg.getAggValue()).level(agg.getLevel()).parent(agg.getParent())
            .children(agg.getChildren()).build();

}
