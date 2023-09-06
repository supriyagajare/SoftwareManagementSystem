package com.example.SoftwareManagementUsingSpring.SoftwareInterface;



import java.util.List;
import java.util.Optional;

import com.example.SoftwareManagementUsingSpring.model.Software;

/* The SoftwareService is service interface 
 * and abstract method declaration
  */
public interface SoftwareService {

	
	Software saveSoftwares(Software software);
	List<Software>  getAllSoftwares(String str);
	Optional<Software> getSoftwareById(int softwareId);
	Software updateSoftwareDetails(Optional<Software> existingSoftware, Software newSoftwareData);
	void deleteSoftwareById(int softwareId);
	void deleteAllSoftwares();
	
}

