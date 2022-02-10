package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Selection implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "学生id")
	private Long studentId;
	
	@ApiModelProperty(value = "课程id")
	private Long courseId;
	
	@ApiModelProperty(value = "所属年级")
	private Integer grade;
	
	@ApiModelProperty(value = "所属星期")
	private Integer week;
	
	@ApiModelProperty(value = "删除标记")
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
	@JsonProperty("studentId")
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId =  studentId;
	}
	@JsonProperty("courseId")
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId =  courseId;
	}
	@JsonProperty("grade")
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade =  grade;
	}
	@JsonProperty("week")
	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week =  week;
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

																
	public Selection(Long id,Long studentId,Long courseId,Integer grade,Integer week,Integer deleted,Date createTime,Date updateTime) {
				
		this.id = id;
				
		this.studentId = studentId;
				
		this.courseId = courseId;
				
		this.grade = grade;
				
		this.week = week;
				
		this.deleted = deleted;
				
		this.createTime = createTime;
				
		this.updateTime = updateTime;
				
	}

	public Selection() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}