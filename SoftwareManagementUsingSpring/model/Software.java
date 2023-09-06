package com.example.SoftwareManagementUsingSpring.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



/**
 * In this class, we declare private attributes to represent software details and
 * provide getters and setters for accessing these attributes.
 */

@Entity
@Table(name = "software_table")
@DynamicUpdate
public class Software {

	
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer softwareId;

		@Column(nullable = false)
		private String softwareName;
		
		@Column
		private String developerName;

		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="developerId")
		private Developer developer;
		
		

//		@ManyToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name="developerId")
//		private Developer developerDetails;
		
//		public void setDeveloperDetails(Developer developerDetails) {
//			this.developerDetails = developerDetails;
//		}

		public String getDeveloperName() {
			return developerName;
		}

		public void setDeveloperName(String developerName) {
			this.developerName = developerName;
		}

		public Developer getDeveloper() {
			return developer;
		}

		public void setDeveloper(Developer developer) {
			this.developer = developer;
		}

		@Column(nullable = false) 
		private int rating;
	    
		@Column(nullable = false) 
		private int price;
		
		 @Column(nullable = false) 
		 private Boolean isDesktopApplication;
		
		

	    public Boolean getIsDesktopApplication() {
			return isDesktopApplication;
		}

		public Integer getSoftwareId() {
			return softwareId;
		}

		public void setSoftwareId(Integer softwareId) {
			this.softwareId = softwareId;
		}

		public void setIsDesktopApplication(Boolean isDesktopApplication) {
			this.isDesktopApplication = isDesktopApplication;
		}

		

		public String getSoftwareName() {
			return softwareName;
		}

		public void setSoftwareName(String softwareName) {
			this.softwareName = softwareName;
		}

		

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

public Software(Integer softwareId, String softwareName, String developerName, Developer developer, int rating,
				int price, Boolean isDesktopApplication) {
			super();
			this.softwareId = softwareId;
			this.softwareName = softwareName;
			this.developerName = developerName;
			this.developer = developer;
			this.rating = rating;
			this.price = price;
			this.isDesktopApplication = isDesktopApplication;
		}

//		public Developer getDeveloperDetails() {
//			return developerDetails;
//		}
		
		
		
	    @Override
		public String toString() {
			return "Software [softwareId=" + softwareId + ", softwareName=" + softwareName + ", developerName="
					+ developerName + ", developer=" + developer + ", rating=" + rating + ", price=" + price
					+ ", isDesktopApplication=" + isDesktopApplication + "]";
		}

		// Default constructor.
		public Software() {
			System.out.println("no args con");	
		}
		

	


			
}