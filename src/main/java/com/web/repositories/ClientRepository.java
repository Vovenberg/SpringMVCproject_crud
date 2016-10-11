package com.web.repositories;

import com.web.entities.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientsEntity,Long> {


}
