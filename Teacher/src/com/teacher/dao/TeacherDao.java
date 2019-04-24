package com.teacher.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.teacher.bean.Teacher;
import com.teacher.mapper.TeacherMapper;

public class TeacherDao {
	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 *            セットする jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Teacher> queryAll() {
		String sql = "select * from teacher";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public List<Teacher> queryByName(String teachername) {
		String sql = "select * from teacher where teachername like'%" + teachername + "%'";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public List<Teacher> queryById(String id) {
		String sql = "select * from teacher where id like'" + id + "'";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public boolean addTeacher(Teacher teacher) {
		String sql = "insert into teacher (id,teachername,course,birthday) value (0,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { teacher.getTeachername(), teacher.getCourse(), teacher.getBirthday() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR }) == 1;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public boolean deleteTeacher(Integer id) {
		String sql = "delete from teacher where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	/**
	 *
	 * @param teacher
	 * @return
	 */
	public boolean updateTeacher(Teacher teacher) {
		String sql = "update teacher set teachername=?,course=?,birthday=? where id =?";
		Object teacherObj[] = new Object[] { teacher.getTeachername(), teacher.getCourse(), teacher.getBirthday(),
				teacher.getId() };
		return jdbcTemplate.update(sql, teacherObj) == 1;
	}
}
