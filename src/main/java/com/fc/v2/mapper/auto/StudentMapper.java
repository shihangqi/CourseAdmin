package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Student;
import com.fc.v2.model.auto.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  StudentMapper
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-12 15:45:20
 */
public interface StudentMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);
		
    Student selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example); 
		
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectRegexpUsername(String regexp);
  	  	
}