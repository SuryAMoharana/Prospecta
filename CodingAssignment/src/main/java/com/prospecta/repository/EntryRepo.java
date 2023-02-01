package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.entity.Entries;

@Repository
public interface EntryRepo extends JpaRepository<Entries, Integer> {
	public Entries findByApi(String api);
}
