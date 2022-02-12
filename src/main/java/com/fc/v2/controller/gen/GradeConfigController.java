package com.fc.v2.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.model.auto.GradeConfig;
import com.fc.v2.service.GradeConfigService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Controller
 * @ClassName: GradeConfigController
 * @author shihangqi
 * @date 2022-02-12 18:44:39
 */
@Api(value = "")
@Controller
@RequestMapping("/GradeConfigController")
public class GradeConfigController extends BaseController{
	
	private String prefix = "gen/gradeConfig";
	
	@Autowired
	private GradeConfigService gradeConfigService;
	
	
	/**
	 * 页面展示
	 * @param model
	 * @return String
	 * @author shihangqi
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:gradeConfig:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:gradeConfig:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,GradeConfig gradeConfig){
		PageInfo<GradeConfig> page=gradeConfigService.list(tablepar,gradeConfig) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:gradeConfig:add")
	@ResponseBody
	public AjaxResult add(GradeConfig gradeConfig){
		int b=gradeConfigService.insertSelective(gradeConfig);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:gradeConfig:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=gradeConfigService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("GradeConfig", gradeConfigService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:gradeConfig:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GradeConfig gradeConfig)
    {
        return toAjax(gradeConfigService.updateByPrimaryKeySelective(gradeConfig));
    }
    
    
    /**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody GradeConfig gradeConfig){
		int i=gradeConfigService.updateVisible(gradeConfig);
		return toAjax(i);
	}

    
    

	
}
