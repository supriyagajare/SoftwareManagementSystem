package com.example.SoftwareManagementUsingSpring.model;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@DynamicUpdate
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
    private String  developerName;
	@Column
    private String developerEmail;
	@Column
    private String developerCountry;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



//	@OneToMany(mappedBy = "developerDetails")
//	private List<Software> softwareList = new ArrayList<>();
	


	
//    @OneToMany(mappedBy="developerDetails")
//    private List<Software> softwareList;

//	@OneToMany(targetEntity = Software.class,cascade = CascadeType.ALL)
//	private List<Software> softwareList = new ArrayList<>();






//	public List<Software> getSoftwareList() {
//		return softwareList;
//	}
//
//
//
//	public void setSoftwareList(List<Software> softwareList) {
//		this.softwareList = softwareList;
//	}







	public String getDeveloperName() {
		return developerName;
	}



	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}



	public String getDeveloperEmail() {
		return developerEmail;
	}



	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}



	public String getDeveloperCountry() {
		return developerCountry;
	}



	public void setDeveloperCountry(String developerCountry) {
		this.developerCountry = developerCountry;
	}



	
	
	
    
    }
