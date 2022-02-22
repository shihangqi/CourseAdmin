package com.fc.v2.controller.gen;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.auto.Student;
import com.fc.v2.model.custom.StudentFile;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.StudentService;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Controller
 * @ClassName: StudentController
 * @author shihangqi
 * @date 2022-02-12 15:45:20
 */
@Api(value = "")
@Controller
@RequestMapping("/StudentController")
public class StudentController extends BaseController{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	private String prefix = "gen/student";
	
	@Autowired
	private StudentService studentService;
	
	
	/**
	 * 页面展示
	 * @param model
	 * @return String
	 * @author shihangqi
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:student:view")
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
	@RequiresPermissions("gen:student:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,Student student){
		PageInfo<Student> page=studentService.list(tablepar,student) ; 
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
	@RequiresPermissions("gen:student:add")
	@ResponseBody
	public AjaxResult add(Student student){
		int b=studentService.insertSelective(student);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 批量新增跳转
	 */
	@ApiOperation(value = "批量新增跳转", notes = "批量新增跳转")
	@GetMapping("/batchAdd")
	public String batchAdd(ModelMap modelMap)
	{
		return prefix + "/batchAdd";
	}

	/**
	 * 批量新增保存
	 * @param
	 * @return
	 */
	@ApiOperation(value = "批量新增", notes = "批量新增")
	@PostMapping("/batchAdd")
	@RequiresPermissions("gen:student:add")
	@ResponseBody
	public AjaxResult batchAdd(@RequestBody MultipartFile object){
		if (!object.getOriginalFilename().endsWith(".csv") && !object.getOriginalFilename().endsWith(".xls") && !object.getOriginalFilename().endsWith(".xlsx")){
			return error("上传文件格式错误！");
		}
		try {
			ExcelReader reader = ExcelUtil.getReader(object.getInputStream());
			List<StudentFile> studentFiles = reader.readAll(StudentFile.class);
			boolean b = studentService.insertByStudentFile(studentFiles);
			if (b){
				return success();
			}
			return error("文件上传失败！");
		}catch (Exception exc){
			LOGGER.error("batchAdd error",exc);
			return error("文件上传失败！");
		}
//		int b=studentService.insertSelective(student);
//		if(b>0){
//			return success();
//		}else{
//			return error();
//		}
	}


	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:student:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=studentService.deleteByPrimaryKey(ids);
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
        map.put("Student", studentService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:student:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student student)
    {
        return toAjax(studentService.updateByPrimaryKeySelective(student));
    }
    
    
    /**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody Student student){
		int i=studentService.updateVisible(student);
		return toAjax(i);
	}

    
    

	
}
