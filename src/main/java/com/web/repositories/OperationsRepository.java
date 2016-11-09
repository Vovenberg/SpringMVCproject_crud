package com.web.repositories;

import com.web.entities.OperationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 04.10.2016.
 */
@Repository
public interface OperationsRepository extends JpaRepository<OperationsEntity, Long> {
}
