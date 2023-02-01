package com.prospecta.entity;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Datas {
	private Integer count;
	private List<Entries> entries;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Entries> getEntries() {
		return entries;
	}
	public void setEntries(List<Entries> entries) {
		this.entries = entries;
	}
	
	
}
