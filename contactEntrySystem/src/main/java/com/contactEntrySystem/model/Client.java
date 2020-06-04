package com.contactEntrySystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Client")
public class Client {
	@Id
	@GeneratedValue
	@Column(name = "CLIENT_ID")
	private long Id;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name_id")
	private Name name;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_id")
	private Phone phone;
	
	@Column(name = "EMail") 
	private String email;
	 
	
	public Client(long id, Name name, Address address, Phone phone, String email) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public Client() {
	}

	public Client(Name name, Address address) {
		this.name = name;
		this.address = address;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
}