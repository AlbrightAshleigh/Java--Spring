package com.ashleigh.ninjadojo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ashleigh.ninjadojo.models.Ninja;
import com.ashleigh.ninjadojo.repositories.NinjaRepository;

@Repository
public class NinjaService {
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}
	
	public void createNinja(Ninja ninja){
		ninjaRepository.save(ninja);
	}
	
	public ArrayList<Ninja> getAll(){
		return (ArrayList<Ninja>) ninjaRepository.findAll();
	}

}
