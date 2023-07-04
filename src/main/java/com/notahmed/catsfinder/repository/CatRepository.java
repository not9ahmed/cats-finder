package com.notahmed.catsfinder.repository;

import com.notahmed.catsfinder.models.Cat;
import org.springframework.data.repository.ListCrudRepository;

public interface CatRepository extends ListCrudRepository<Cat, Long> {


}
