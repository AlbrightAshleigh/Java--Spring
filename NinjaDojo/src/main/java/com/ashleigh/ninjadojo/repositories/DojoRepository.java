package com.ashleigh.ninjadojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ashleigh.ninjadojo.models.Dojo;

public interface DojoRepository extends CrudRepository <Dojo, Long> {

}
