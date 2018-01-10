package com.lpf.mvc.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *JDBC操作的工具类
 * @author lipengfei
 *
 */
public class JdbcUtils {

	/**
	 * 释放Connection连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	private static DataSource dataSource = null;
	static{
		//将数据源的创建放在静态代码块中，因为数据源只需要创建一次
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	/**
	 * 返回数据源的一个Connection对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	} 
}
