package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 视图控制层    课程
 * @author WE
 *
 */
@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	/**
	 * 查询所有课程信息
	 */
	@ApiOperation(value="查询所有课程信息",notes="保存课程信息时无需输入id")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list =courseService.findAllCourse();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}		
	}
	/**
	 * 通过id查询课程信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value="通过id查询课程信息")
	@GetMapping("findCourseById")
	public MsgResponse findCourseById(@RequestParam long id){
		Course course = new Course();
		try {
			course = courseService.findCourseById(id);
			return MsgResponse.success("success", course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 通过id删除课程信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value="通过id删除课程信息")
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(@RequestParam long id){
		//调用service层代码完成课程信息的删除
		try {
			courseService.deleteCourseById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	}
	/**
	 * 通过关键字查询课程信息
	 * @param keywords
	 * @return
	 */
	@ApiOperation(value="通过关键字查询课程信息")
	@GetMapping("findCourseByKeyword")
	public MsgResponse findCourseByKeyword(@RequestParam String keywords){
		try {
			List<Course> course = courseService.findCourseByKeyword(keywords);
			return MsgResponse.success("success", course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	/**
	 * 保存或更新课程信息
	 * @param course
	 * @return
	 */
	@ApiOperation(value="保存或更新课程信息")
	@PostMapping("saveOrUpdateCourse")
	public MsgResponse saveOrUpdateCourse(Course course){
		try {
			courseService.saveOrUpdateCourse(course);
			return MsgResponse.success("success", course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 批量删除课程信息
	 * @param ids
	 * @return
	 */
	@ApiOperation(value="批量删除课程信息")
	@GetMapping("batchDeleteCourse")
	public MsgResponse batchDeleteCoure(Long[] ids){
		try {
			courseService.batchDeleteCourse(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
}
