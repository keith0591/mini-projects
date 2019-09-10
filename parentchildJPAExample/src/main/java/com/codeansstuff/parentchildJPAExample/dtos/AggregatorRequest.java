package com.codeansstuff.parentchildJPAExample.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author MalkeithSingh on 09-09-2019
 */
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AggregatorRequest {

    private String aggKey;
    private String aggValue;
}
