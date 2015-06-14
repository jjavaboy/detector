package com.lam.alarm.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@Title:DetectorDao.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-5-1 ÏÂÎç03:22:37
 *@Version:1.0
 */
@Component("detectorDao")
public class DetectorDao extends JdbcDaoSupport{

	public void insertDepartment(){
		String sql = "insert into department(deptid, deptname) value('0001', 'dept0001')";
		getJdbcTemplate().update(sql);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={Throwable.class})
	public void save_transaction() throws SQLException {
		Connection conn = getJdbcTemplate().getDataSource().getConnection();
		String sql = "delete from department where deptid = '0001'";
		String sql1 = "update department set deptname = 'newnamenewnamenewname' where deptid = '0002'";
		conn.createStatement().execute(sql);
		conn.createStatement().execute(sql1);
	}

}

