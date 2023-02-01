package com.prospecta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.entity.Datas;
import com.prospecta.entity.Entries;
import com.prospecta.entity.EntryDTO;
import com.prospecta.exception.EntryException;
import com.prospecta.service.EntryService;

import lombok.Data;

@RestController
public class EntryController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EntryService eService;

	
	@GetMapping("/entries")
	public ResponseEntity<List<EntryDTO>> getentryHandler(){
		Datas data = restTemplate.getForObject("https://api.publicapis.org/entries", Datas.class);
		List<Entries> apientries = data.getEntries();
		List<EntryDTO> results = new ArrayList<>();
		for(Entries e : apientries) {
			EntryDTO eDto = new EntryDTO();
			eDto.setTitle(e.getApi());
			eDto.setDescription(e.getDescription());
			results.add(eDto);	
		}
		return new ResponseEntity<List<EntryDTO>>(results, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDTO>> getHandler(@PathVariable("category") String category) {

		Datas data = restTemplate.getForObject("https://api.publicapis.org/entries", Datas.class);
		List<Entries> entries = data.getEntries();

		List<EntryDTO> result = new ArrayList<>();

		for (Entries e : entries) {
			if(e.getCategory().equals(category)) {
				EntryDTO EDTO = new EntryDTO();
				EDTO.setTitle(e.getApi());
				EDTO.setDescription(e.getDescription());
				result.add(EDTO);
			}
		}
		return new ResponseEntity<List<EntryDTO>>(result, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntryHandler(@RequestBody Entries entry)throws EntryException{	
		return new ResponseEntity<String>(eService.saveEntry(entry),HttpStatus.CREATED);	
	}
}
