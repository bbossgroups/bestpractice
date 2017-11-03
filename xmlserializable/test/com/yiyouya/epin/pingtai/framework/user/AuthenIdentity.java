package com.yiyouya.epin.pingtai.framework.user;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import com.yiyouya.epin.pingtai.framework.entity.Operation;
import com.yiyouya.epin.pingtai.framework.entity.UserInfo;

public class AuthenIdentity implements Serializable {
	private UserInfo user;
	/*private Staff teacher;
	private Freshmen freshmen;
	private Student student;*/
	private Set<Operation> operations = new TreeSet<Operation>();
	public AuthenIdentity(){
		
	}
	/*public AuthenIdentity(UserInfo user, Staff asTeacher, Freshmen asFreshmen, Student asStudent, Set<Operation> operations){
		this.user = user;
		this.teacher = asTeacher;
		this.freshmen = asFreshmen;
		this.student = asStudent;
		this.operations.addAll(operations);
	}*/
	
	public AuthenIdentity(UserInfo user, Set<Operation> operations){
		this.user = user;
		/*this.teacher = asTeacher;
		this.freshmen = asFreshmen;
		this.student = asStudent;*/
		this.operations.addAll(operations);
	}
	
	public UserInfo getUser() {
		return user;
	}
	
	public String getName(){
		String name = null;
		/*if(user.getType() == Constants.STAFF)
			name = teacher.getName();
		else if(user.getType() == Constants.STUDENT_AT_CAMPUS){
			name = student.getName();
		} else if(user.getType() == Constants.FRESH_MEN){
			name = freshmen.getName();
		} else{
			name = user.getUserId();
		}*/
		return name;
	}
	public String getUserId() {
		return user.getUserId();
	}
	public Set<Operation> getOperations(){
		return operations;
	}
	
	/*public Student getStudent(){
		return this.student;
	}
	
	public Staff getTeacher(){
		return this.teacher;
	}
	
	public Freshmen getFreshmen(){
		return this.freshmen;
	}*/

}
