package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private Long id;
	
	@ApiModelProperty(value = "用户名")
	private String userName;
	
	@ApiModelProperty(value = "学生名")
	private String name;
	
	@ApiModelProperty(value = "所属年级")
	private Integer grade;
	
	@ApiModelProperty(value = "所属班级")
	private Integer clazz;
	
	@ApiModelProperty(value = "头像")
	private String avatar;
	
	@ApiModelProperty(value = "密码")
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "最后登陆时间")
	private Date lastLoginTime;
	
	@ApiModelProperty(value = "最后登录ip")
	private String lastLoginIp;
	
	@ApiModelProperty(value = "状态")
	private Integer deleted;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName =  userName;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =  name;
	}
	@JsonProperty("grade")
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade =  grade;
	}
	@JsonProperty("clazz")
	public Integer getClazz() {
		return clazz;
	}

	public void setClazz(Integer clazz) {
		this.clazz =  clazz;
	}
	@JsonProperty("avatar")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar =  avatar;
	}
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =  password;
	}
	@JsonProperty("lastLoginTime")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime =  lastLoginTime;
	}
	@JsonProperty("lastLoginIp")
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp =  lastLoginIp;
	}
	@JsonProperty("deleted")
	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted =  deleted;
	}
	@JsonProperty("createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime =  createTime;
	}
	@JsonProperty("updateTime")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime =  updateTime;
	}

																								
	public Student(Long id,String userName,String name,Integer grade,Integer clazz,String avatar,String password,Date lastLoginTime,String lastLoginIp,Integer deleted,Date createTime,Date updateTime) {
				
		this.id = id;
				
		this.userName = userName;
				
		this.name = name;
				
		this.grade = grade;
				
		this.clazz = clazz;
				
		this.avatar = avatar;
				
		this.password = password;
				
		this.lastLoginTime = lastLoginTime;
				
		this.lastLoginIp = lastLoginIp;
				
		this.deleted = deleted;
				
		this.createTime = createTime;
				
		this.updateTime = updateTime;
				
	}

	public Student() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}