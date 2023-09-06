package com.example.SoftwareManagementUsingSpring.SoftwareController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SoftwareManagementUsingSpring.SoftwareService.EmailService;
import com.example.SoftwareManagementUsingSpring.model.Software;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	@RequestMapping("/")
	public ResponseEntity<String> checkEmail(@RequestParam(required = false) String userEmail, @RequestBody Software softwareDetails )  //user email, rest obj(@request Body 
	{
		String softwareName=softwareDetails.getSoftwareName();
		String strMsg = softwareDetails.getSoftwareName()+" "+softwareDetails.getSoftwareName()+" "+softwareDetails.getIsDesktopApplication();
		
	System.out.println(softwareDetails);
	emailService.sendEmail(userEmail, "Your Software" +softwareName+" is confirmed!", "We are pleased to inform you that you have successfully purchased the software. "
			+ "You can find additional information below.\n"
			+strMsg+" ");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}
}