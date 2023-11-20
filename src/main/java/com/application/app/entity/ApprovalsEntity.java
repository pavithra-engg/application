package com.application.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class ApprovalsEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)//To Create SerailNo
	@Id//Primary Key
	@Column(name = "userid")
	private int userid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
		

}
