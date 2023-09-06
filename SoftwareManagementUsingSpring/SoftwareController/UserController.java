package com.example.SoftwareManagementUsingSpring.SoftwareController;





import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SoftwareManagementUsingSpring.SoftwareRepository.SoftwareRepository;
import com.example.SoftwareManagementUsingSpring.SoftwareService.UserServiceImplementation;
import com.example.SoftwareManagementUsingSpring.model.User;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	//open postm
	@Autowired
	private UserServiceImplementation userServ;
	
	
	@Autowired
	private SoftwareRepository softwareRepo;
	
	
		@PostMapping("/softwareTable/{softwareId}")
		public ResponseEntity<Map<String,String>> addBooking(@PathVariable("softwareId") int softwareId,@RequestBody User user)
		{
		
				User obj=new User();
				Random rand = new Random();
				obj.setUserEmail(user.getUserEmail());
				obj.setUserName(user.getUserName());
				obj.setDate(user.getDate());
				int userId=rand.nextInt(11111);
				obj.setUserID(userId);
				obj.setSoftwareDetails(this.softwareRepo.findById( softwareId).get());
				this.userServ.addUser(obj);
				Map<String,String> response=new HashMap<String,String>();
				response.put("status", "success");
				response.put("message", "Comment added!!");
			
					return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
			
		}
		
		@GetMapping("/softwareUsers/{softwareId}")
		public List<User> getUsersBySoftwareId(@PathVariable long softwareId)
		{
			List<User> userList = new ArrayList<User>();
			userList = this.userServ.findBookedUsersBySoftwareId(softwareId);
			
			return  userList;
			
		}

}
