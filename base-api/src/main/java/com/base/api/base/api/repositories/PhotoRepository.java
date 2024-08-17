package com.base.api.base.api.repositories;

import com.base.api.base.api.models.Photos;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photos, Integer> {
}
