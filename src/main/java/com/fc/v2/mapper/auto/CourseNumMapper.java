package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.CourseNum;
import com.fc.v2.model.auto.CourseNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  CourseNumMapper
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-09 23:11:08
 */
public interface CourseNumMapper {
      	   	      	      	      	      	      	      
    long countByExample(CourseNumExample example);

    int deleteByExample(CourseNumExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(CourseNum record);

    int insertSelective(CourseNum record);

    List<CourseNum> selectByExample(CourseNumExample example);
		
    CourseNum selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") CourseNum record, @Param("example") CourseNumExample example);

    int updateByExample(@Param("record") CourseNum record, @Param("example") CourseNumExample example); 
		
    int updateByPrimaryKeySelective(CourseNum record);

    int updateByPrimaryKey(CourseNum record);
  	  	
}