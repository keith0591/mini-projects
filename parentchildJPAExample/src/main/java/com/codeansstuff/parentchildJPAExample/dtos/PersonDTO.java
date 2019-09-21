package com.codeansstuff.parentchildJPAExample.dtos;

import com.codeansstuff.parentchildJPAExample.entity.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @author MalkeithSingh on 11-09-2019
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"hibernate_lazy_initializer", "handler"})
public class PersonDTO {

    private Long id;
    private String fullName;
    private Person parent;
    private Set<Person> children;
}
