package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private Long id;
	
	@ApiModelProperty(value = "课程名称")
	private String name;
	
	@ApiModelProperty(value = "所属年级")
	private Integer grade;
	
	@ApiModelProperty(value = "所属星期")
	private Integer week;
	
	@ApiModelProperty(value = "简介图片")
	private String imgUrl;
	
	@ApiModelProperty(value = "课程简介")
	private String introduction;
	
	@ApiModelProperty(value = "课程详情")
	private String description;
	
	@ApiModelProperty(value = "课程详情中的图片")
	private String descriptionImg;
	
	@ApiModelProperty(value = "授课教师")
	private Long teacherId;
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
	@JsonProperty("week")
	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week =  week;
	}
	@JsonProperty("imgUrl")
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl =  imgUrl;
	}
	@JsonProperty("introduction")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction =  introduction;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("descriptionImg")
	public String getDescriptionImg() {
		return descriptionImg;
	}

	public void setDescriptionImg(String descriptionImg) {
		this.descriptionImg =  descriptionImg;
	}
	@JsonProperty("teacherId")
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId =  teacherId;
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

																						
	public Course(Long id,String name,Integer grade,Integer week,String imgUrl,String introduction,String description,String descriptionImg,Long teacherId,Date createTime,Date updateTime) {
				
		this.id = id;
				
		this.name = name;
				
		this.grade = grade;
				
		this.week = week;
				
		this.imgUrl = imgUrl;
				
		this.introduction = introduction;
				
		this.description = description;
				
		this.descriptionImg = descriptionImg;
				
		this.teacherId = teacherId;
				
		this.createTime = createTime;
				
		this.updateTime = updateTime;
				
	}

	public Course() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}