package com.notahmed.catsfinder.repository;

import com.notahmed.catsfinder.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {


    User findUserByUsername(String username);

    Boolean existsByUsername(String username);

}
