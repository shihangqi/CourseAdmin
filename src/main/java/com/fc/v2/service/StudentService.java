package com.fc.v2.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.StudentMapper;
import com.fc.v2.model.auto.Student;
import com.fc.v2.model.auto.StudentExample;
import com.fc.v2.model.custom.StudentFile;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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


    public boolean insertByStudentFile(List<StudentFile> studentFiles) {
		for (StudentFile studentFile : studentFiles) {
			String pinYin = getPinYin(studentFile.getName());
			Student student = new Student();

			String userName = pinYin;
			List<Student> students = studentMapper.selectRegexpUsername(pinYin+"[0-9]");
			if (!students.isEmpty()){
				int num = Integer.parseInt(students.get(0).getUserName().substring(pinYin.length()-1));
				userName = pinYin + num;
			}
			student.setName(studentFile.getName());
			student.setUserName(userName);
			student.setGrade(studentFile.getGrade());
			student.setClazz(studentFile.getClazz());
			student.setPassword(DigestUtil.sha256Hex("123456"));
			int insert = studentMapper.insert(student);
			if (insert==0){
				return false;
			}
		}
		return true;
    }

    private String getPinYin(String s){
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : s.toCharArray()) {
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
			stringBuilder.append(Arrays.toString(pinyinArray));
		}
		return stringBuilder.toString();
	}


}
