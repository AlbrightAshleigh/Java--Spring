package com.ashleigh.ninjadojo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ashleigh.ninjadojo.models.Dojo;
import com.ashleigh.ninjadojo.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository){
		this.dojoRepository = dojoRepository;
	}
	
	public void addDojo(Dojo dojo){
		dojoRepository.save(dojo);
	}

	public ArrayList<Dojo> getAll(){
		return (ArrayList<Dojo>) dojoRepository.findAll();
	}
	
	public Dojo getOneById(Long id){
		return dojoRepository.findOne(id);
	}
}
