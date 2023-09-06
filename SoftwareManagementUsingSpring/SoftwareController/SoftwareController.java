package com.example.SoftwareManagementUsingSpring.SoftwareController;

	
		import java.util.List;
import java.util.Map;
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

import com.example.SoftwareManagementUsingSpring.SoftwareService.SoftwareServiceImplementation;
import com.example.SoftwareManagementUsingSpring.model.Developer;
import com.example.SoftwareManagementUsingSpring.model.Software;


/*
 * The SoftwareController class is a Spring RestController responsible for handling
 * HTTP requests related to software data. It provides endpoints for performing CRUD
 * (Create, Read, Update, Delete) operations on software items.
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController //itself annotated with @Controller and @ResponseBody. 
@RequestMapping("/api/v1/software")

	public class SoftwareController {

	    // Dependency on the SoftwareServiceImplementation for business logic
		@Autowired
		public SoftwareServiceImplementation softwareServImpl;

		
		
		
		
		
		
		
		
//		@PostMapping("/{developerId}")
//		public ResponseEntity<Map<String,String>> addSoftwareDetails(@PathVariable("developerId") int developerId,@RequestBody Developer developer)
//		{
//	    	Optional<Software> existSoftware = softwareServImpl.getSoftwareById(developerId);
//
//			if (existSoftware.isPresent()) {
//				Software softwareFromDb = existSoftware.get();
//				softwareFromDb.setDeveloper(developer);
//				softwareServImpl.saveSoftwares(softwareFromDb);
//				return new ResponseEntity<>(HttpStatus.OK);
//			}
//			else
//			{
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//					
//		}
		
		
		
		 @GetMapping("/searchByDevName")
		    public ResponseEntity<List<Software>> getAllSoftwareByDeveloperName(@RequestParam(required = false) String developerName) {
		        try {
		            System.out.println("Received developerName: " + developerName);
		            List<Software> softwareList = softwareServImpl.getAllSoftwareByDeveloperName(developerName);

		            if (softwareList.isEmpty()) {
		                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		            }
		            return new ResponseEntity<>(softwareList, HttpStatus.OK);
		        } catch (Exception e) {
		            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		        }
		    }
		
		

		
		
		

		

	    // Constructor to inject the SoftwareServiceImplementation dependency
		public SoftwareController(SoftwareServiceImplementation softwareServImpl) {
			this.softwareServImpl = softwareServImpl;
		}

		
		
		
	    // To save a new software
		@PostMapping
		public ResponseEntity<Software> saveSoftware(@RequestBody Software name){
			System.out.println(name);
			try {
			return new ResponseEntity<Software>(softwareServImpl.saveSoftwares(name), HttpStatus.CREATED);
			}

			catch(Exception e)
			{
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
		}
		
		
	    // To update the details of an existing software
		@PutMapping("/{softwareId}")
		public ResponseEntity<Software> updateSoftwareDetailsById(@PathVariable int softwareId,@RequestBody Software softwareDetails){
			Optional<Software> softwareData=softwareServImpl.getSoftwareById(softwareId);
			
			if(softwareData.isPresent())
			{
				softwareServImpl.updateSoftwareDetails(softwareData, softwareDetails);
				return new ResponseEntity<Software>(softwareServImpl.updateSoftwareDetails(softwareData, softwareDetails), HttpStatus.OK);

			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		
	    // To retrieve a list of all software items
		@GetMapping
			public ResponseEntity<List<Software>> getAllSoftwares(@RequestParam(required = false) String name) {
			try {
				List<Software> softwareList = softwareServImpl.getAllSoftwares(name);
			
				if(softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(softwareList, HttpStatus.OK);  
				
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
		
		
		
		
		
		
	    // To retrieve a specific software item by its ID
		@GetMapping("/getSoftware/{id}")
		public ResponseEntity<Software>  getSoftwareById(@PathVariable("id")  int softwareId){
			System.out.println(softwareId);
			
			Optional<Software> software = softwareServImpl.getSoftwareById(softwareId);
			
			if(software.isPresent())
			{
				return new ResponseEntity<>(software.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		
		

	    // To delete a specific software item by its ID
		@DeleteMapping("/software/{softwareId}")
		
		public ResponseEntity<String> deleteSoftwareById(@PathVariable("softwareId")  int softwareId){
			Optional<Software> softwareData=softwareServImpl.getSoftwareById(softwareId);

			try {
				if(softwareData.isPresent())
				{
					softwareServImpl.deleteSoftwareById(softwareId);
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
	
		
		

		//deleteAll Data
		@DeleteMapping("/software")
		public ResponseEntity<HttpStatus> deleteAllSoftwares(){
			try
			{
				softwareServImpl.deleteAllSoftwares();
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			catch(Exception exception) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Search any Data
		@GetMapping("/{name}")
		public ResponseEntity<List<Software>> getAllSoftware(@PathVariable("name") String softwareName){
			
			try {
			
				if(softwareName != null) {
					
					return new ResponseEntity<>(softwareServImpl.getBySoftwareDetailsBySoftwareName(softwareName), HttpStatus.OK);
				}
		}
			catch(Exception excep) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return null;
		}
		
		
		@GetMapping("/isDesktopSoftware")
		public ResponseEntity<List<Software>> findByDesktopApplication() {
			try {
				List<Software> software = softwareServImpl.findByIsDesktopApplication(true);

				if (software.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(software, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/isWebApplicationSoftware")
		public ResponseEntity<List<Software>> findByWebApplication() {
			try {

				List<Software> restaurant = softwareServImpl.findByIsDesktopApplication(false);

				if (restaurant.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(restaurant, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
		@GetMapping("/filter/Rating/{direction}")
		public ResponseEntity<List<Software>> getAllSoftwareByRatingseHighToLow(@PathVariable("direction") String direction, @RequestParam(required = true) String rating){

			try {
				List<Software> softwareList = softwareServImpl.getAllSoftwareByRatingsHighToLow(direction, rating);
				if (softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(softwareList, HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		
		
		@GetMapping("/filter/Price/{direction}")
		public ResponseEntity<List<Software>> getAllSoftwareByPriceHighToLow(@PathVariable("direction") String direction, @RequestParam(required = true) String price){

			try {
				List<Software> softwareList = softwareServImpl.getAllSoftwareByPriceDesc(direction, price);
				System.out.println(direction);
				if (softwareList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(softwareList, HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		
		
		//New.........................
		@GetMapping("/byDeveloper/{developerId}")
		public List<Software> getSoftwareByDeveloperId(@PathVariable Long developerId) 
			{
				 return softwareServImpl.getSoftwareByDeveloperId(developerId);
			}
	}
