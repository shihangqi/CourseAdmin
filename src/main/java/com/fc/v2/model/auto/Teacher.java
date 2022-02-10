package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "id")
	private Integer id;
	
	@ApiModelProperty(value = "教师姓名")
	private String name;
	
	@ApiModelProperty(value = "职位")
	private String position;
	
	@ApiModelProperty(value = "简介")
	private String description;
	
	@ApiModelProperty(value = "生活照url")
	private String imgUrl;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =  name;
	}
	@JsonProperty("position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position =  position;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("imgUrl")
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl =  imgUrl;
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

														
	public Teacher(Integer id,String name,String position,String description,String imgUrl,Date createTime,Date updateTime) {
				
		this.id = id;
				
		this.name = name;
				
		this.position = position;
				
		this.description = description;
				
		this.imgUrl = imgUrl;
				
		this.createTime = createTime;
				
		this.updateTime = updateTime;
				
	}

	public Teacher() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}