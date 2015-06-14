package com.lam.alarm.service;

import java.sql.SQLException;

import com.lam.alarm.dao.DetectorDao;

/**
 *@Title:DetectorService.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-5-1 обнГ03:22:23
 *@Version:1.0
 */
public class DetectorService {
	
	private DetectorDao detectorDao;
	
	public void setDetectorDao(DetectorDao detectorDao) {
		this.detectorDao = detectorDao;
	}

	public void test_transaction() throws SQLException {
		detectorDao.save_transaction();	
	}

	public void insertDepartment() {
		detectorDao.insertDepartment();
	}

}

