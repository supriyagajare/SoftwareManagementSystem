package com.example.SoftwareManagementUsingSpring.SoftwareInterface;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.SoftwareManagementUsingSpring.SoftwareRepository.DeveloperRepository;
import com.example.SoftwareManagementUsingSpring.model.Developer;


@Service
public class DeveloperService {
    @Autowired
    DeveloperRepository developerRepository;
    
    public void createDeveloper(Developer developer){
    	developerRepository.save(developer);
    }
    
    
    public Optional<Developer> getDeveloperById(int developerId)
	{
		Optional<Developer> developer=developerRepository.findById(developerId);
		return developer;
	}

    public Developer updatDeveloper( Optional<Developer> DeveloperDetails,Developer newVal) {
		Developer developer =DeveloperDetails.get();
		developer.setDeveloperName(newVal.getDeveloperName());
		developer.setDeveloperEmail(newVal.getDeveloperEmail());
		developer.setDeveloperCountry(newVal.getDeveloperCountry());
		return developerRepository.save(developer);
	}
    public void deleteDeveloper(int id ){
    	developerRepository.deleteById(id);
    }


	
	
	
	public List<Developer> getDeveloperFromDb(String title) {
		List<Developer> developer = new ArrayList<Developer>();

		if (title == null)
			developerRepository.findAll().forEach(developer::add);


		else
			developerRepository.findByDeveloperNameContainingIgnoreCase(title).forEach(developer::add);

		return  developer;
	}


	public void deleteAll() {
		// TODO Auto-generated method stub
		developerRepository.deleteAll();
	}




}
