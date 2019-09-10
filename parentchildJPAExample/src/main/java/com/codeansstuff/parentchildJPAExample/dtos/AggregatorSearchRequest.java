package com.codeansstuff.parentchildJPAExample.dtos;

import com.codeansstuff.parentchildJPAExample.constants.AggregatorSearchType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Set;

/**
 * @author MalkeithSingh on 09-09-2019
 */
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class AggregatorSearchRequest {

    private Integer aggId;
    private AggregatorSearchType searchIn;
    private Set<AggregatorRequest> aggregators;

}
