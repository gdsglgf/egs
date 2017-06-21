package com.mybatis.examples.db;

import java.sql.Connection;
import java.sql.SQLException;
import com.alibaba.druid.pool.DruidDataSource;

public class DruidManager {
	private DruidManager() {
	}

	private static DruidManager single = null;
	private DruidDataSource dataSource;

	public synchronized static DruidManager getInstance() {
		if (single == null) {
			single = new DruidManager();
			single.initPool();
		}
		return single;
	}

	private void initPool() {
		dataSource = new DruidDataSource();
		dataSource.setDriverClassName(Constants.DRIVERCLASSNAME);
		dataSource.setUsername(Constants.USERNAME);
		dataSource.setPassword(Constants.PASSWORD);
		dataSource.setUrl(Constants.URL);
		dataSource.setInitialSize(5);
		dataSource.setMinIdle(1);
		dataSource.setMaxActive(10);
		// 启用监控统计功能
		try {
			dataSource.setFilters("stat");
		} catch (SQLException e) {

		} // for mysql
		dataSource.setPoolPreparedStatements(false);
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {

		}
		return connection;
	}
}