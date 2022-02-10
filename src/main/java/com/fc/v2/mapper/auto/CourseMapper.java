package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Course;
import com.fc.v2.model.auto.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  CourseMapper
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-09 23:11:30
 */
public interface CourseMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);
		
    Course selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example); 
		
    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
  	  	
}