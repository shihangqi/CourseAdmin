package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class GradeConfig implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "年级")
	private Integer grade;
	
	@ApiModelProperty(value = "标题")
	private String titel;
	
	@ApiModelProperty(value = "简介")
	private String description;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "开始填写时间")
	private Date beginTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "结束填写时间")
	private Date endTime;
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
	@JsonProperty("grade")
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade =  grade;
	}
	@JsonProperty("titel")
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel =  titel;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("beginTime")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime =  beginTime;
	}
	@JsonProperty("endTime")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime =  endTime;
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

																
	public GradeConfig(Long id,Integer grade,String titel,String description,Date beginTime,Date endTime,Date createTime,Date updateTime) {
				
		this.id = id;
				
		this.grade = grade;
				
		this.titel = titel;
				
		this.description = description;
				
		this.beginTime = beginTime;
				
		this.endTime = endTime;
				
		this.createTime = createTime;
				
		this.updateTime = updateTime;
				
	}

	public GradeConfig() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}