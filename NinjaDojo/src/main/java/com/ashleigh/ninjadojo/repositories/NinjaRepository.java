package com.ashleigh.ninjadojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashleigh.ninjadojo.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long> {

}
