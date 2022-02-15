package com.fc.v2.model.custom;

/**
 * @Author: shihangqi
 * @create: 2022年02月13日 23:08
 * @program: CourseAdmin
 * @description:
 **/
public class StudentFile {

    private String name;

    private Integer grade;

    private Integer clazz;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }
}
