package com.yiyouya.epin.pingtai.framework.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the ar_user database table.
 * 
 */
 
public class UserInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public UserInfo() {
	}

 
	private Integer id;
	
 
	private String userId;
	 
	private String mobile;
	 
	private String workEmail;
	 
	private String password;
	 
//	@JsonIgnore
	private String loginKey;
	 
	private String name;

//	@Column(name="avatar")
//	private String avatar;
 
	private Integer status;
	 
	private Integer sex;
	 
	private String idCard;
	
/*	@Column(name="person_email")
	private String personEmail;
	
	@Column(name="join_date")
	private Date joinDate;
	
	@Column(name="contract_start_date")
	private Date contractStartDate;
	
	@Column(name="contract_end_date")
	private Date contractEndDate;
	
	@Column(name="five_insurance")
	private String fiveInsurance;
	
	@Column(name="census_register")
	private String censusRegister;
	
	@Column(name="residence")
	private String residence;
	
	@Column(name="emergency_contact")
	private String emergencyContact;
	
	@Column(name="emergency_tel")
	private String emergencyTel;*/
	
	 
	private Integer orgId;
	
	 
	private Integer type;

	 
	private Integer createId;
	
	 
	private Integer updateId;
	
	 
	private Timestamp createTime;
	
	 
	private Timestamp updateTime;
	
	 
	private Integer deleteFlag;
	
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginKey() {
		return loginKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

//	public String getAvatar() {
//		return avatar;
//	}
//
//	public void setAvatar(String avatar) {
//		this.avatar = avatar;
//	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}


    
 

}