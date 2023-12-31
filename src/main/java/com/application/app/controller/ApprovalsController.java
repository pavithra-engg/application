package com.application.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.app.service.ApprovalsService;

@RestController
@CrossOrigin
public class ApprovalsController {
	
	@Autowired 
	ApprovalsService userserddd;
	
	@GetMapping("/studentdetails/{userid}")
	Map<String, Object> getDetails(@PathVariable String userid) {

		return userserddd.getDetails(userid); 
	}

	@PostMapping("/updatenextusers/{studentid}/{levelsflag}/{levelsstatus}/{userid}")
	Map<String, Object> updateNextUsers(@PathVariable Integer studentid,@PathVariable String levelsflag,@PathVariable String levelsstatus,@PathVariable String userid) {
	
		return userserddd.updateNextUserApprovalInsert(studentid, levelsflag, levelsstatus, userid);
	}

	
}
