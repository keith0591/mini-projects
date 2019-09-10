package com.codeansstuff.parentchildJPAExample.repositories;

import com.codeansstuff.parentchildJPAExample.entity.Aggregators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author MalkeithSingh on 09-09-2019
 */
@Repository
public interface AggregatorRepo extends JpaRepository<Aggregators,Long>, JpaSpecificationExecutor<Aggregators> {
}
