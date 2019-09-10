package com.codeansstuff.parentchildJPAExample.dtos;

import com.codeansstuff.parentchildJPAExample.entity.Aggregators;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @author MalkeithSingh on 09-09-2019
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AggregatorsDTO {

    private Long aggId;
    private String aggKey;
    private String aggValue;
    private Integer level;
    private Aggregators parent;
    private Set<Aggregators> children;
}
