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
import com.fc.v2.mapper.auto.CourseNumMapper;
import com.fc.v2.model.auto.CourseNum;
import com.fc.v2.model.auto.CourseNumExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  CourseNumService
 * @Title: CourseNumService.java 
 * @Package com.fc.v2.service 
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-09 23:11:08  
 **/
@Service
public class CourseNumService implements BaseService<CourseNum, CourseNumExample>{
	@Autowired
	private CourseNumMapper courseNumMapper;
	
      	   	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<CourseNum> list(Tablepar tablepar,CourseNum courseNum){
	        CourseNumExample testExample=new CourseNumExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(courseNum);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<CourseNum> list= courseNumMapper.selectByExample(testExample);
	        PageInfo<CourseNum> pageInfo = new PageInfo<CourseNum>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			CourseNumExample example=new CourseNumExample();
			example.createCriteria().andIdIn(stringB);
			return courseNumMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public CourseNum selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return courseNumMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(CourseNum record) {
		return courseNumMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(CourseNum record) {
				
		record.setId(null);
		
				
		return courseNumMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(CourseNum record, CourseNumExample example) {
		
		return courseNumMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(CourseNum record, CourseNumExample example) {
		
		return courseNumMapper.updateByExample(record, example);
	}

	@Override
	public List<CourseNum> selectByExample(CourseNumExample example) {
		
		return courseNumMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CourseNumExample example) {
		
		return courseNumMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CourseNumExample example) {
		
		return courseNumMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param courseNum
	 * @return
	 */
	public int updateVisible(CourseNum courseNum) {
		return courseNumMapper.updateByPrimaryKeySelective(courseNum);
	}


}
