package com.fc.v2.service;

import java.util.List;
import java.util.Arrays;

import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.StudentMapper;
import com.fc.v2.model.auto.Student;
import com.fc.v2.model.auto.StudentExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  StudentService
 * @Title: StudentService.java 
 * @Package com.fc.v2.service 
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-12 15:45:20  
 **/
@Service
public class StudentService implements BaseService<Student, StudentExample>{
	@Autowired
	private StudentMapper studentMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Student> list(Tablepar tablepar,Student student){
	        StudentExample testExample=new StudentExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(student);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Student> list= studentMapper.selectByExample(testExample);
	        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			StudentExample example=new StudentExample();
			example.createCriteria().andIdIn(stringB);
			return studentMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public Student selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return studentMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Student record) {
		record.setPassword(DigestUtil.sha256Hex(record.getPassword()));
		record.setId(null);
		return studentMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Student record, StudentExample example) {
		record.setPassword(DigestUtil.sha256Hex(record.getPassword()));
		return studentMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Student record, StudentExample example) {
		record.setPassword(DigestUtil.sha256Hex(record.getPassword()));
		return studentMapper.updateByExample(record, example);
	}

	@Override
	public List<Student> selectByExample(StudentExample example) {
		
		return studentMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(StudentExample example) {
		
		return studentMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(StudentExample example) {
		
		return studentMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param student
	 * @return
	 */
	public int updateVisible(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student);
	}


}
