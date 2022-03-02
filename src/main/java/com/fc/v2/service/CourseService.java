package com.fc.v2.service;

import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.CourseMapper;
import com.fc.v2.model.auto.Course;
import com.fc.v2.model.auto.CourseExample;
import com.fc.v2.model.auto.CourseNum;
import com.fc.v2.model.auto.Teacher;
import com.fc.v2.model.custom.CourseFile;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * CourseService
 *
 * @author shihangqi_自动生成
 * @Title: CourseService.java 
 * @Package com.fc.v2.service 
 * @email ${email}
 * @date 2022-02-12 18:45:49  
 **/
@Service
public class CourseService implements BaseService<Course, CourseExample> {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseNumService courseNumService;

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Course> list(Tablepar tablepar, Course course) {
        CourseExample testExample = new CourseExample();
        //搜索
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
            testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
        } else {//大搜索
            testExample.createCriteria().andLikeQuery(course);
        }
        //表格排序
        //if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
        //}else{
        //	testExample.setOrderByClause("id ASC");
        //}
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<Course> list = courseMapper.selectByExample(testExample);
        PageInfo<Course> pageInfo = new PageInfo<Course>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {

        Long[] integers = ConvertUtil.toLongArray(",", ids);
        List<Long> stringB = Arrays.asList(integers);
        CourseExample example = new CourseExample();
        example.createCriteria().andIdIn(stringB);
        return courseMapper.deleteByExample(example);


    }


    @Override
    public Course selectByPrimaryKey(String id) {

        Long id1 = Long.valueOf(id);
        return courseMapper.selectByPrimaryKey(id1);


    }


    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * 添加
     */
    @Override
    public int insertSelective(Course record) {

        record.setId(null);


        return courseMapper.insertSelective(record);
    }


    @Override
    public int updateByExampleSelective(Course record, CourseExample example) {

        return courseMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(Course record, CourseExample example) {

        return courseMapper.updateByExample(record, example);
    }

    @Override
    public List<Course> selectByExample(CourseExample example) {

        return courseMapper.selectByExample(example);
    }


    @Override
    public long countByExample(CourseExample example) {

        return courseMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(CourseExample example) {

        return courseMapper.deleteByExample(example);
    }

    /**
     * 修改权限状态展示或者不展示
     *
     * @param course
     * @return
     */
    public int updateVisible(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }


    public boolean insertByCourseFiles(List<CourseFile> courseFiles) throws IllegalAccessException {

        for (CourseFile courseFile : courseFiles) {
            Class cls = courseFile.getClass();
            Field[] fields = cls.getDeclaredFields();
            for(int i=0; i<fields.length; i++){
                Field f = fields[i];
                f.setAccessible(true);
                System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(courseFile));
            }
            //新建教师信息
            Teacher teacher = new Teacher();
            teacher.setName(courseFile.getTeacherName());
            teacher.setDescription(courseFile.getDescriptionImg());
            teacher.setPosition(courseFile.getTeacherPosition());
            teacher.setImgUrl(courseFile.getTeacherImg());
			int i = teacherService.insertSelective(teacher);
			if (i==0){
				return false;
			}
			//新建课程信息
			Course course = new Course();
            course.setName(courseFile.getCourseName());
            course.setGrade(courseFile.getGrade());
            course.setWeek(courseFile.getWeek());
            course.setImgUrl(courseFile.getImg());
            course.setIntroduction(courseFile.getIntroduction());
            course.setDescription(courseFile.getDescription());
            course.setDescriptionImg(courseFile.getDescriptionImg());
            course.setId(teacher.getId().longValue());
			int b = courseMapper.insertSelective(course);
			if (b==0){
				return false;
			}
			CourseNum courseNum = new CourseNum();
			courseNum.setCourseId(course.getId());
            courseNum.setTotal(courseFile.getTotal());
            courseNum.setAllowance(courseFile.getTotal());
            int c = courseNumService.insertSelective(courseNum);
            if (c==0){
                return false;
            }
        }
        return true;
    }
}
