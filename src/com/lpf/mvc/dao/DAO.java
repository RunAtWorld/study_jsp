package com.lpf.mvc.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lpf.mvc.db.JdbcUtils;

/**
 * @author lipengfei
 *封装了基本的CRUD的方法，以供子类继承使用，当前DAO直接在方法中获取数据库连接(无事务)
 *整个DAO采取DBUtils解决方案
 * @param <T>:当前DAO处理的实体类的类型是什么
 */
public class DAO<T> {
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;

	public DAO(){
		Type superClass = getClass().getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			
			Type [] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs!=null&&typeArgs.length>0){
				clazz = (Class<T>) typeArgs[0];
			}
		}
	}
	/**
	 * 返回 一个字段的值:例如返回一条记录的customerName,或返回数据表中有多少条记录
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 返回T对应的List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 返回一个T对应的实例类的对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 封装 INSERT,DELETE,UPDATE操作
	 * @param sql:SQL语句
	 * @param args:填充SQL语句的占位符
	 */
	public void update(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection,sql,args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
	}
}
