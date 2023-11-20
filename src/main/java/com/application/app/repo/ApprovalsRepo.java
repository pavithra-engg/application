package com.application.app.repo;

import java.util.List;

import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.app.entity.ApprovalsEntity;

@Repository
public interface ApprovalsRepo extends JpaRepository<ApprovalsEntity, Integer>{

	
	@Query(nativeQuery = true, value = "select * from studentsdata where userid=:userid ")
	List<Map<String, Object>> getDetails(@Param("userid") String userid);
	
	@Modifying
	@org.springframework.transaction.annotation.Transactional
	@Query(nativeQuery = true, value = "update students set levelsflag=:levelsflag,levelstatus=:levelstatus,userid=:userid where studentid=:studentid")
	
	int updateNextUser(@Param("levelsflag") String levelsflag,@Param("levelstatus") String levelstatus,@Param("userid") String userid,@Param("studentid") Integer studentid);
	
	
	
	@Modifying
	@org.springframework.transaction.annotation.Transactional
	@Query(nativeQuery = true, value = "insert into studentsdataapproval(studentid,levelsflag,levelsstatus,userid) values(:studentid,:levelsflag,:levelsstatus,:userid) ")
	
	int updateNextUserApprovalInsert(@Param("studentid") Integer studentid,@Param("levelsflag") String levelsflag,@Param("levelsstatus") String levelsstatus,@Param("userid") String userid);
		
	
	@Modifying
	@org.springframework.transaction.annotation.Transactional
	@Query(nativeQuery = true, value = "update studentsdata set levelsflag=:levelsflag,userid=:userid where studentid=:studentid")
	
	int updateNextUserDynamic(@Param("levelsflag") String levelsflag,@Param("userid") String userid,@Param("studentid") Integer studentid);
	
	@Query(nativeQuery = true, value = "select levelsflag from users where cast(levelsflag as integer) > cast(:levelsflag as integer) order by levelsflag limit 1 ")
	String getNextLevel(@Param("levelsflag") String levelsflag);
	
	
	@Query(nativeQuery = true, value = "select username from users where cast(levelsflag as integer) > cast(:levelsflag as integer) order by levelsflag limit 1 ")
	String getNextLevelUser(@Param("levelsflag") String levelsflag);
}
