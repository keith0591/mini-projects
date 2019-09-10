package com.codeansstuff.parentchildJPAExample.repositories;

import com.codeansstuff.parentchildJPAExample.dtos.AggregatorRequest;
import com.codeansstuff.parentchildJPAExample.dtos.AggregatorSearchRequest;
import com.codeansstuff.parentchildJPAExample.entity.Aggregators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author MalkeithSingh on 09-09-2019
 */
@Slf4j
public class AggregatorsSpecification {

    public static Specification<Aggregators> searchInAgg(AggregatorSearchRequest request) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> andPredicates = new ArrayList<>();
            if (Objects.nonNull(request.getAggId())) {
                andPredicates.add(criteriaBuilder.equal(root.get("aggId"), request.getAggId()));
            }
            buildSearchCriteriaForAggregators(request,root,criteriaBuilder).ifPresent(andPredicates::add);
            return criteriaBuilder.and(andPredicates.toArray(new Predicate[0]));
        };
    }

    /**
     * The methods build the criteria to search in an aggregator or either the parent or children of an aggregator
     */
    private static Optional<Predicate> buildSearchCriteriaForAggregators(AggregatorSearchRequest request, Root<Aggregators> root,
                                                                         CriteriaBuilder cb) {

        Predicate searchForAnyOneAgg = null;
        if (Objects.nonNull(request.getAggregators()) && Objects.nonNull(root) && Objects.nonNull(cb) && !request.getAggregators().isEmpty()) {

            BiFunction<AggregatorRequest,Join<Aggregators, Aggregators>, Predicate> mapToPredicate = (agg,join) -> {
                Predicate searchInRoot = cb.and(cb.equal(root.get("aggKey"), agg.getAggKey()), cb.equal(root.get("aggValue"), agg.getAggValue()));
                Predicate searchInSuppliedJoin = cb.and(cb.equal(join.get("aggKey"), agg.getAggKey()), cb.equal(join.get("aggValue"), agg.getAggValue()));
                return cb.or(searchInRoot,searchInSuppliedJoin);
            };

            switch (request.getSearchIn()) {
                case PARENT:
                Join<Aggregators, Aggregators> parent = root.join("parent");
                searchForAnyOneAgg = cb.or(request.getAggregators().stream().map(agg->mapToPredicate.apply(agg,parent)).toArray(Predicate[]::new));
                break;

                case CHILDREN:
                Join<Aggregators, Aggregators> children = root.join("children");
                searchForAnyOneAgg = cb.or(request.getAggregators().stream().map(agg->mapToPredicate.apply(agg,children)).toArray(Predicate[]::new));
                break;

                default:
                    log.error("Invalid search condition specified");
            }

        }
        return Optional.ofNullable(searchForAnyOneAgg);
    }


}
