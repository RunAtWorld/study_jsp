package com.lpf.mvc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.lpf.mvc.db.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
