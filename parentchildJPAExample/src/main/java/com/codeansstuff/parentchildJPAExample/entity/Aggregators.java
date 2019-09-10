package com.codeansstuff.parentchildJPAExample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.Set;

/**
 * @author MalkeithSingh on 08-09-2019
 */
@Entity
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Aggregators {

    @Id
    private Long aggId;
    private String aggKey;
    private String aggValue;
    private Integer level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_agg_Id")
    private Aggregators parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Aggregators> children;

    @JsonIgnore
    public Set<Aggregators> getChildren() {
        return children;
    }

    public void setChildren(Set<Aggregators> children) {
        this.children = children;
    }

    public Long getAggId() {
        return aggId;
    }

    public void setAggId(Long aggId) {
        this.aggId = aggId;
    }

    public String getAggKey() {
        return aggKey;
    }

    public void setAggKey(String aggKey) {
        this.aggKey = aggKey;
    }

    public String getAggValue() {
        return aggValue;
    }

    public void setAggValue(String aggValue) {
        this.aggValue = aggValue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Aggregators getParent() {
        return parent;
    }

    public void setParent(Aggregators parent) {
        this.parent = parent;
    }

}
