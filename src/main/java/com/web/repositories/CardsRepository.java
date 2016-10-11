package com.web.repositories;

import com.web.entities.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 04.10.2016.
 */
@Repository
public interface CardsRepository extends JpaRepository<CardsEntity,Long> {
}
