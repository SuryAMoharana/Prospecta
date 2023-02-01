package com.prospecta.service;

import java.util.List;

import com.prospecta.entity.Entries;
import com.prospecta.exception.EntryException;

public interface EntryService {
	public String saveEntry(Entries entries)throws EntryException; 
	public List<Entries> getAllEntries(); 
}
