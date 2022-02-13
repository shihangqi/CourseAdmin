package com.fc.v2.model.custom;

import com.fc.v2.model.auto.Course;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: shihangqi
 * @create: 2022年02月12日 22:59
 * @program: CourseAdmin
 * @description:
 **/
public class CourseVo extends Course {

    @ApiModelProperty(value = "课程总量")
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
