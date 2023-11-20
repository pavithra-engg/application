package com.app.application.app.service;

import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ApprovalsService {
	
	Map<String, Object> getDetails(String userid);
	

	
	Map<String, Object> updateNextUserApprovalInsert(Integer studentid,String levelsflag, String levelsstatus,String userid);

}
