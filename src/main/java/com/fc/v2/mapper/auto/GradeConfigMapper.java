package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.GradeConfig;
import com.fc.v2.model.auto.GradeConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  GradeConfigMapper
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-12 18:44:39
 */
public interface GradeConfigMapper {
      	   	      	      	      	      	      	      	      	      
    long countByExample(GradeConfigExample example);

    int deleteByExample(GradeConfigExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(GradeConfig record);

    int insertSelective(GradeConfig record);

    List<GradeConfig> selectByExample(GradeConfigExample example);
		
    GradeConfig selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") GradeConfig record, @Param("example") GradeConfigExample example);

    int updateByExample(@Param("record") GradeConfig record, @Param("example") GradeConfigExample example); 
		
    int updateByPrimaryKeySelective(GradeConfig record);

    int updateByPrimaryKey(GradeConfig record);
  	  	
}