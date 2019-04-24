package com.school.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.school.bean.School;



public class SchoolMapper implements RowMapper<School> {

	@Override
	public School mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		School school = new School();
		school.setId(rs.getInt("id"));
		school.setSchoolname(rs.getString("schoolname"));
		school.setAddress(rs.getString("address"));
		school.setBuildtime(getStringDate(rs.getString("buildtime")));
		school.setCountryname(rs.getString("countryname"));
		return school;
	}
	private  String getStringDate(String buildtime) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(buildtime);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}
}