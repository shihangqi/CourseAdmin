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
import com.fc.v2.mapper.auto.TeacherMapper;
import com.fc.v2.model.auto.Teacher;
import com.fc.v2.model.auto.TeacherExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  TeacherService
 * @Title: TeacherService.java 
 * @Package com.fc.v2.service 
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-09 22:49:41  
 **/
@Service
public class TeacherService implements BaseService<Teacher, TeacherExample>{
	@Autowired
	private TeacherMapper teacherMapper;
	
      	   	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Teacher> list(Tablepar tablepar,Teacher teacher){
	        TeacherExample testExample=new TeacherExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(teacher);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Teacher> list= teacherMapper.selectByExample(testExample);
	        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			TeacherExample example=new TeacherExample();
			example.createCriteria().andIdIn(stringB);
			return teacherMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Teacher selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return teacherMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Teacher record) {
		return teacherMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Teacher record) {
				
		record.setId(null);
		
				
		return teacherMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Teacher record, TeacherExample example) {
		
		return teacherMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Teacher record, TeacherExample example) {
		
		return teacherMapper.updateByExample(record, example);
	}

	@Override
	public List<Teacher> selectByExample(TeacherExample example) {
		
		return teacherMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(TeacherExample example) {
		
		return teacherMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(TeacherExample example) {
		
		return teacherMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param teacher
	 * @return
	 */
	public int updateVisible(Teacher teacher) {
		return teacherMapper.updateByPrimaryKeySelective(teacher);
	}


}
