package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.bean.School;
import com.school.dao.SchoolDao;

@Controller

public class SchoolController {
/**
 *
 * @param model
 * @return
 */
@RequestMapping (value="/school")
 public String queryAll(Model model) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SchoolDao sDao=(SchoolDao) context.getBean("sDao") ;
	List<School> schoolList = new ArrayList<School>();
	schoolList = sDao.queryAll();
	model.addAttribute("schools", schoolList);
	return "indexSchool";

}
/**
 *
 * @param schoolname
 * @param model
 * @return
 */
@RequestMapping (value="/queryByschName")
public String queryByschName(String schoolname,Model model) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SchoolDao sDao=(SchoolDao) context.getBean("sDao") ;
	List<School> schoolList = new ArrayList<School>();
	schoolList = sDao.queryByschName(schoolname);
	model.addAttribute("schools", schoolList);
	return "indexSchool";
}
/**
 *
 * @param id
 * @param model
 * @return
 */
@RequestMapping (value="/queryByschId")
public String queryByschId(String id,Model model) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SchoolDao sDao=(SchoolDao) context.getBean("sDao") ;
	List<School> schoolList = new ArrayList<School>();
	schoolList = sDao.queryByschId(id);
	model.addAttribute("schools", schoolList);
	return "indexSchool";

}
/**
 *
 * @param schoolname
 * @param address
 * @param buildtime
 * @param countryname
 * @param model
 * @return
 */
@RequestMapping (value="/addschool")
public String addSchool(String schoolname,String address,String buildtime,String countryname ,Model model ) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SchoolDao sDao=(SchoolDao) context.getBean("sDao") ;
	School school = new School();
	school.setSchoolname(schoolname);
	school.setAddress(address);
	school.setBuildtime(buildtime);
	school.setCountryname(countryname);
	boolean result=sDao.addSchool(school);
	model.addAttribute("schools", sDao.queryAll());
	return "indexSchool";

}

}

