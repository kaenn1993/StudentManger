package com.teacher.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.teacher.bean.Teacher;

public class TeacherMapper implements RowMapper <Teacher>{
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher teacher = new Teacher();
		teacher.setId(rs.getInt("id"));
		teacher.setTeachername(rs.getString("teachername"));
		teacher.setCourse(rs.getString("course"));
		teacher.setBirthday(getStringDate(rs.getString("birthday")));
		return teacher;
	}
	private  String getStringDate(String birthday) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(birthday);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}
}
