package com.prospecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.entity.Entries;
import com.prospecta.exception.EntryException;
import com.prospecta.repository.EntryRepo;

@Service
public class EntryServiceImpl implements EntryService {
	
	@Autowired
	private EntryRepo ERepo;
	
	@Override
	public String saveEntry(Entries entries)throws EntryException {
		Entries en =   ERepo.findByApi(entries.getApi());
		
		if(en!=null) {
			 throw new EntryException("Invalid Entry") ;
		}else {
			ERepo.save(entries);
			return "success";
		}			
	}
	
	@Override
	public List<Entries> getAllEntries() {
		// TODO Auto-generated method stub
		return ERepo.findAll();
	}
	
}
