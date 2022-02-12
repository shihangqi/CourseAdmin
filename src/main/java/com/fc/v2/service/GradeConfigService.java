package com.fc.v2.service;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.GradeConfigMapper;
import com.fc.v2.model.auto.GradeConfig;
import com.fc.v2.model.auto.GradeConfigExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  GradeConfigService
 * @Title: GradeConfigService.java 
 * @Package com.fc.v2.service 
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-12 18:44:39  
 **/
@Service
public class GradeConfigService implements BaseService<GradeConfig, GradeConfigExample>{
	@Autowired
	private GradeConfigMapper gradeConfigMapper;
	
      	   	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<GradeConfig> list(Tablepar tablepar,GradeConfig gradeConfig){
	        GradeConfigExample testExample=new GradeConfigExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(gradeConfig);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<GradeConfig> list= gradeConfigMapper.selectByExample(testExample);
	        PageInfo<GradeConfig> pageInfo = new PageInfo<GradeConfig>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			GradeConfigExample example=new GradeConfigExample();
			example.createCriteria().andIdIn(stringB);
			return gradeConfigMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public GradeConfig selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return gradeConfigMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(GradeConfig record) {
		return gradeConfigMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(GradeConfig record) {
				
		record.setId(null);
		
				
		return gradeConfigMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(GradeConfig record, GradeConfigExample example) {
		
		return gradeConfigMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(GradeConfig record, GradeConfigExample example) {
		
		return gradeConfigMapper.updateByExample(record, example);
	}

	@Override
	public List<GradeConfig> selectByExample(GradeConfigExample example) {
		
		return gradeConfigMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(GradeConfigExample example) {
		
		return gradeConfigMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(GradeConfigExample example) {
		
		return gradeConfigMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param gradeConfig
	 * @return
	 */
	public int updateVisible(GradeConfig gradeConfig) {
		return gradeConfigMapper.updateByPrimaryKeySelective(gradeConfig);
	}


}
