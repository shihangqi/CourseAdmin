package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Selection;
import com.fc.v2.model.auto.SelectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  SelectionMapper
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-12 18:44:00
 */
public interface SelectionMapper {
      	   	      	      	      	      	      	      	      	      
    long countByExample(SelectionExample example);

    int deleteByExample(SelectionExample example);
		
    int deleteByPrimaryKey(Long id);
		
    int insert(Selection record);

    int insertSelective(Selection record);

    List<Selection> selectByExample(SelectionExample example);
		
    Selection selectByPrimaryKey(Long id);
		
    int updateByExampleSelective(@Param("record") Selection record, @Param("example") SelectionExample example);

    int updateByExample(@Param("record") Selection record, @Param("example") SelectionExample example); 
		
    int updateByPrimaryKeySelective(Selection record);

    int updateByPrimaryKey(Selection record);
  	  	
}