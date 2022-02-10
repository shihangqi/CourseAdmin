package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Teacher;
import com.fc.v2.model.auto.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  TeacherMapper
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-09 22:49:41
 */
public interface TeacherMapper {
      	   	      	      	      	      	      	      	      
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);
		
    Teacher selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example); 
		
    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
  	  	
}