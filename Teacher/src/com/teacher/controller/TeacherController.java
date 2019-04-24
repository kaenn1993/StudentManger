package com.teacher.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teacher.bean.Teacher;
import com.teacher.dao.TeacherDao;

@Controller

public class TeacherController {
	@RequestMapping(value = "/teacher")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao tdao = (TeacherDao) context.getBean("tdao");
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = tdao.queryAll();
		model.addAttribute("teachers", teacherList);
		return "indexTeacher";
}
	@RequestMapping(value = "/queryByName")
	public String queryByName(String teachername,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao tdao = (TeacherDao) context.getBean("tdao");
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = tdao.queryByName(teachername);
		model.addAttribute("teachers", teacherList);
		return "indexTeacher";

	}

	@RequestMapping(value = "/queryById")
	public String queryById(String id,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao tdao = (TeacherDao) context.getBean("tdao");
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = tdao.queryById(id);
		model.addAttribute("teachers", teacherList);
		return "indexTeacher";

	}

	@RequestMapping(value = "/addTea")
	public String addTeacher(String teachername,String course,String birthday,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//iocからdaoを函る
		TeacherDao tdao = (TeacherDao) context.getBean("tdao");
		Teacher teacher = new Teacher();
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		teacher.setBirthday(birthday);
		boolean result=tdao.addTeacher(teacher);
		if(result) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		model.addAttribute("teachers", tdao.queryAll());
		return "indexTeacher";
	}

	@RequestMapping(value = "/deleteById")
	public String deleteById(String id,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao tdao = (TeacherDao) context.getBean("tdao");
		boolean result=tdao.deleteTeacher(Integer.parseInt(id));
		if(result) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		model.addAttribute("teachers", tdao.queryAll());
		return "indexTeacher";

	}

	@RequestMapping(value = "/update")
	public String updateTeacher(String id,String teachername,String course,String birthday,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao tdao = (TeacherDao) context.getBean("tdao");
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(id));
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		teacher.setBirthday(birthday);
		boolean result=tdao.updateTeacher(teacher);
		if(result) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		model.addAttribute("teachers", tdao.queryAll());
		return "indexTeacher";
	}
}
