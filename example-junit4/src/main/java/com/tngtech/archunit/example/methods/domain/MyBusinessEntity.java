package com.tngtech.archunit.example.methods.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyBusinessEntity {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
