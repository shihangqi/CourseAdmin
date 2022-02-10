package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class CourseNum implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "课程id")
	private Long courseId;
	
	@ApiModelProperty(value = "课程总量")
	private Integer total;
	
	@ApiModelProperty(value = "课程余量")
	private Integer allowance;
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
	@JsonProperty("courseId")
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId =  courseId;
	}
	@JsonProperty("total")
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total =  total;
	}
	@JsonProperty("allowance")
	public Integer getAllowance() {
		return allowance;
	}

	public void setAllowance(Integer allowance) {
		this.allowance =  allowance;
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

												
	public CourseNum(Long id,Long courseId,Integer total,Integer allowance,Date createTime,Date updateTime) {
				
		this.id = id;
				
		this.courseId = courseId;
				
		this.total = total;
				
		this.allowance = allowance;
				
		this.createTime = createTime;
				
		this.updateTime = updateTime;
				
	}

	public CourseNum() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}