package com.example.SoftwareManagementUsingSpring.SoftwareService;

import java.util.ArrayList;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SoftwareManagementUsingSpring.SoftwareInterface.SoftwareService;
import com.example.SoftwareManagementUsingSpring.SoftwareRepository.SoftwareRepository;
import com.example.SoftwareManagementUsingSpring.model.Developer;
import com.example.SoftwareManagementUsingSpring.model.Software;


/**
 *SoftwareServiceImplementation class service class provides the business logic to interact
 *with software items in the database. It implements the SoftwareServe interface to perform CRUD (Create,
 *Read, Update, Delete) operations on software items.
 */
@Service
public class SoftwareServiceImplementation implements SoftwareService
{

	SoftwareRepository softwareRepository;



	public SoftwareServiceImplementation (SoftwareRepository softwareRepository) {
		this.softwareRepository=softwareRepository;
	}

    // Method to save a new software item to the database
	@Override
	public Software saveSoftwares(Software softwares) {
		return softwareRepository.save(softwares);

	}




    // Method to retrieve a list of all software items from the database
	@Override
	public List<Software> getAllSoftwares(String title) {
		List<Software> software = new ArrayList<Software>();
		if(title==null)
		 softwareRepository.findAll().forEach(software::add);
		else
			softwareRepository.findBySoftwareNameContainingIgnoreCase(title).forEach(software::add);
		return software;
	}
	
    // Method to retrieve a specific software item by its ID from the database
	@Override
	public Optional<Software>  getSoftwareById(int softwareId) {
		Optional<Software> software = softwareRepository.findById(softwareId);
		return software;
	}


    // Method to update the details of an existing software item in the database
	@Override
	public Software updateSoftwareDetails( Optional <Software> existingSoftware,Software newSoftwareData) {

			Software software = existingSoftware.get();

			software.setSoftwareName(newSoftwareData.getSoftwareName());
//			software.setDeveloperDetails(newSoftwareData.getDeveloperDetails());
			software.setRating(newSoftwareData.getRating());
			software.setPrice(newSoftwareData.getPrice());
			return softwareRepository.save(software);
		}
	
    // Method to delete a specific software item by its ID from the database
	@Override
	public void deleteSoftwareById(int softwareId) {
		softwareRepository.deleteById(softwareId);
	}

	
	public List<Software>getBySoftwareDetailsBySoftwareName(String softwareName) {
		List<Software> SoftwareList = new ArrayList<>();
		softwareRepository.findBySoftwareNameContainingIgnoreCase(softwareName).forEach(SoftwareList::add);
		return SoftwareList;
	}
	


	/*Delete All data by id*/
	public void deleteAllSoftwares() {
		softwareRepository.deleteAll();	
		
	}

	//search isDesktop and web app Restaurant Data to the Database   
		public List<Software> findByIsDesktopApplication(boolean status) {
			return softwareRepository.findByIsDesktopApplication(status);
		}

//		public List getAllSoftwaresByDevName(String developerName) {
//			List<Software> software = new ArrayList<Software>();
//			if(developerName==null)
//			 softwareRepository.findAll().forEach(software::add);
//			else
//				softwareRepository.findByDeveloperContainingIgnoreCase(developerName).forEach(software::add);
//			return software;
//			
//		}
		
		
		public List<Software> getAllSoftwareByPriceDesc(String direction,String price) {
			List<Software> software = softwareRepository.findAll(Sort.by(getSortDirection(direction), price));
			return software;
		}

		public List<Software> getAllSoftwareByRatingsHighToLow(String direction,String rating) {
			List<Software> software = softwareRepository.findAll(Sort.by(getSortDirection(direction), rating));
			return software;
		}
		
		
		private Sort.Direction getSortDirection(String direction) {
		    if (direction.equals("asc")) {
		      return Sort.Direction.ASC;
		    } else if (direction.equals("desc")) {
		      return Sort.Direction.DESC;
		    }

		    return Sort.Direction.ASC;
		  }

		public List<Software> getSoftwareByDeveloperId(Long developerId) {
			// TODO Auto-generated method stub
			  return softwareRepository.findByDeveloperId(developerId);

		}

		public List<Software> getAllSoftwareByDeveloperName(String developerName) {
	        return softwareRepository.findByDeveloperNameIgnoreCase(developerName);
	    }
		
//	    public List<Software> getAllSoftwaresByDevName(String developerName) {
//	        List<Software> softwareList = new ArrayList<>();
//	        if (developerName == null) {
//	            softwareRepository.findAll().forEach(softwareList::add);
//	        } else {
//	            softwareRepository.findByDeveloper_DeveloperNameIgnoreCase(developerName).forEach(softwareList::add);
//	        }
//	        return softwareList;
//	    }
	
	    
	   


}
