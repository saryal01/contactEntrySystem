package com.contactEntrySystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	 @Column(name = "NUMBER")
    private String number;
    @Column(name = "TYPE")
    private String type;
   
	public Phone(long id, String number, String type) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
	}


	


	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
}
