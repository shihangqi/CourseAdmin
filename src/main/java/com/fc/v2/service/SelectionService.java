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
import com.fc.v2.mapper.auto.SelectionMapper;
import com.fc.v2.model.auto.Selection;
import com.fc.v2.model.auto.SelectionExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  SelectionService
 * @Title: SelectionService.java 
 * @Package com.fc.v2.service 
 * @author shihangqi_自动生成
 * @email ${email}
 * @date 2022-02-09 23:11:48  
 **/
@Service
public class SelectionService implements BaseService<Selection, SelectionExample>{
	@Autowired
	private SelectionMapper selectionMapper;
	
      	   	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Selection> list(Tablepar tablepar,Selection selection){
	        SelectionExample testExample=new SelectionExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(selection);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Selection> list= selectionMapper.selectByExample(testExample);
	        PageInfo<Selection> pageInfo = new PageInfo<Selection>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			Long[] integers = ConvertUtil.toLongArray(",", ids);
			List<Long> stringB = Arrays.asList(integers);
			SelectionExample example=new SelectionExample();
			example.createCriteria().andIdIn(stringB);
			return selectionMapper.deleteByExample(example);
		
				
	}
	
	
	@Override
	public Selection selectByPrimaryKey(String id) {
				
			Long id1 = Long.valueOf(id);
			return selectionMapper.selectByPrimaryKey(id1);
			
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Selection record) {
		return selectionMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Selection record) {
				
		record.setId(null);
		
				
		return selectionMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Selection record, SelectionExample example) {
		
		return selectionMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Selection record, SelectionExample example) {
		
		return selectionMapper.updateByExample(record, example);
	}

	@Override
	public List<Selection> selectByExample(SelectionExample example) {
		
		return selectionMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(SelectionExample example) {
		
		return selectionMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(SelectionExample example) {
		
		return selectionMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param selection
	 * @return
	 */
	public int updateVisible(Selection selection) {
		return selectionMapper.updateByPrimaryKeySelective(selection);
	}


}
