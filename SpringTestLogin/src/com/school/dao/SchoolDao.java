package com.school.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.school.bean.School;
import com.school.mapper.SchoolMapper;

public class SchoolDao {

	private JdbcTemplate jdbcTemplate;
	/**
	 * @param jdbcTemplate セットする jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 *
	 * @return schoolList
	 */
	public List<School> queryAll(){
		String sql = "select * from school";
		List<School> schoolList = new ArrayList<School>();
		schoolList=jdbcTemplate.query(sql, new SchoolMapper());
		return schoolList;
	}
	/**
	 *
	 * @param schoolname
	 * @return
	 */
	public List<School> queryByschName(String schoolname){
		String sql = "select * from school where schoolname like'%"+schoolname+"%'";
		List<School> schoolList = new ArrayList<School>();
		schoolList=jdbcTemplate.query(sql, new SchoolMapper());
		return schoolList;
	}
/**
 *
 * @param id
 * @return
 */
	public List<School> queryByschId(String id){
		String sql = "select * from school where id like'"+id+"'";
		List<School> schoolList = new ArrayList<School>();
		schoolList=jdbcTemplate.query(sql, new SchoolMapper());
		return schoolList;
	}
	/**
	 *
	 * @param school
	 * @return
	 */
	public boolean addSchool (School school) {
		String sql = "insert into school (id,schoolname,address,buildtime,countryname) value (0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] {school.getSchoolname(),school.getAddress(),school.getBuildtime(),school.getCountryname()},
				new int [] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR})== 1;

	}
}
