package com.example.SoftwareManagementUsingSpring.SoftwareController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SoftwareManagementUsingSpring.SoftwareInterface.DeveloperService;
import com.example.SoftwareManagementUsingSpring.model.Developer;
import com.example.SoftwareManagementUsingSpring.model.Software;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    @PostMapping
    public ResponseEntity createDeveloper(@RequestBody Developer developer){
    	developerService.createDeveloper(developer);
        return new ResponseEntity("Developer created", HttpStatus.CREATED);
    }

    
//    @GetMapping("getAllSoftware/{id}")
//	public List<Software> getAllSoftware(@PathVariable("id") int id){
//		Optional<Developer> existDeveloper = developerService.getDeveloperById(id);
//
//		if (existDeveloper.isPresent()) {
//			Developer developerFromDB = existDeveloper.get();
//			return developerFromDB.getSoftwareList();
//		}
//		else {
//			return null;
//		}
//	}
    
    
    @PutMapping("/updateDeveloper/{id}")
	public ResponseEntity<Developer> updateDeveloper(@PathVariable int id, @RequestBody Developer updateDeveloper){

		Optional<Developer> developerData=developerService.getDeveloperById(id);

		if(developerData.isPresent())
		{
			developerService.updatDeveloper(developerData, updateDeveloper);
			return new ResponseEntity<>(developerService.updatDeveloper(developerData, updateDeveloper),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @GetMapping
	public ResponseEntity<List<Developer>> getAllDeveloper(@RequestParam(required = false) String name) {
		try {
			List<Developer> developerList  = developerService.getDeveloperFromDb(name);

			
			if (developerList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(developerList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    

    @DeleteMapping("/deleteDeveloper/{id}")
    public ResponseEntity<String> deleteSoftwareById(@PathVariable("id")  int id){
		Optional<Developer> developerData=developerService.getDeveloperById(id);
		try {
			if(developerData.isPresent())
			{
				developerService.deleteDeveloper(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    
    @DeleteMapping
	public ResponseEntity<HttpStatus> deleteAll(){
		try
		{
			developerService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<Developer> getDeveloperById(@PathVariable("id")  int id){

		System.out.println(id);
		//serv.methid name 
		Optional<Developer> existDeveloper = developerService.getDeveloperById(id);

		if (existDeveloper.isPresent()) {
			return new ResponseEntity<>(existDeveloper.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
}
