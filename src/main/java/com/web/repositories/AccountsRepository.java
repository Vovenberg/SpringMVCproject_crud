package com.web.repositories;

import com.web.entities.AccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Repository
public interface AccountsRepository extends CrudRepository<AccountsEntity,Long> {
}
