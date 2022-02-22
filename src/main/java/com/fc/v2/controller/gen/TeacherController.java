package com.fc.v2.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.conf.oss.OssConfig;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.auto.Teacher;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.TeacherService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Controller
 * @ClassName: TeacherController
 * @author shihangqi
 * @date 2022-02-12 18:46:21
 */
@Api(value = "")
@Controller
@RequestMapping("/TeacherController")
public class TeacherController extends BaseController{
	
	private String prefix = "gen/teacher";
	
	@Autowired
	private TeacherService teacherService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);


	/**
	 * 页面展示
	 * @param model
	 * @return String
	 * @author shihangqi
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:teacher:view")
    @OssConfig
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
	@RequiresPermissions("gen:teacher:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,Teacher teacher){
		PageInfo<Teacher> page=teacherService.list(tablepar,teacher) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    @OssConfig
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
	@RequiresPermissions("gen:teacher:add")
	@ResponseBody
	public AjaxResult add(Teacher teacher){
		int b=teacherService.insertSelective(teacher);
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
	@RequiresPermissions("gen:teacher:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=teacherService.deleteByPrimaryKey(ids);
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
    @OssConfig
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("Teacher", teacherService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:teacher:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Teacher teacher)
    {
        return toAjax(teacherService.updateByPrimaryKeySelective(teacher));
    }
    
    
    /**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody Teacher teacher){
		int i=teacherService.updateVisible(teacher);
		return toAjax(i);
	}

    
    

	
}
