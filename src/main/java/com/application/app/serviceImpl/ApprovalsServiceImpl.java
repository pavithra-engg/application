package com.application.app.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.application.app.service.ApprovalsService;
import com.application.app.repo.ApprovalsRepo;

@Service
public class ApprovalsServiceImpl implements ApprovalsService{
	
	@Autowired
	ApprovalsRepo usersrepo; 

	@Override
	public Map<String, Object> getDetails(String userid) {
		Map<String, Object> resObj = new LinkedHashMap<String, Object>();

		List<Map<String, Object>> RepoVar12 = usersrepo.getDetails(userid);

		resObj.put("getstudentdetails", RepoVar12);

		return resObj;
	}
	
	
	@Override
	public Map<String, Object> updateNextUser(String levelsflag, String levelstatus, String userid, Integer studentid) {
		Map<String, Object> repo = new LinkedHashMap<String, Object>();

		int updated = usersrepo.updateNextUser(levelsflag, levelstatus, userid, studentid);
		System.out.println("updated:::::" + updated);

		if (updated > 0) {

			repo.put("responseid", "1");
			repo.put("responsedesc", "Update Successfully");

		} else {

			repo.put("responseid", "2");
			repo.put("responsedesc", "Fail to Update");

		}
		return repo;
	}

	@Override
	@Transactional
	public Map<String, Object> updateNextUserApprovalInsert(Integer studentid, String levelsflag, String levelsstatus,
			String userid) {
		
		
		Map<String, Object> repo = new LinkedHashMap<String, Object>();

		int updated = usersrepo.updateNextUserApprovalInsert(studentid, levelsflag, levelsstatus, userid);
		
		String nextlevelsflag=usersrepo.getNextLevel(levelsflag);
		String nextlevelsflaguser=usersrepo.getNextLevelUser(nextlevelsflag);
		
		int updated1=usersrepo.updateNextUserDynamic(nextlevelsflag, nextlevelsflaguser, studentid);
		
		System.out.println("updated:::::" + updated);

		if (updated > 0 && updated1>0) {

			repo.put("responseid", "1");
			repo.put("responsedesc", "Update Successfully");

		} else {

			repo.put("responseid", "2");
			repo.put("responsedesc", "Fail to Update");

		}
		return repo;
		
	}

}
