package com.lam.alarm.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *@Title:IndexDao.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-13 обнГ10:44:28
 *@Version:1.0
 */
public class IndexDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public List queryUserForLogin(String user_code){
		String sql = "select user_name, password from users where user_name = ?";
		return jdbcTemplate.queryForList(sql, new Object[]{user_code});
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}

