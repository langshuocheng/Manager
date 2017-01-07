package com.echo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.echo.Model.Person;

/**
 * 
 * Person(员工)的增删改查方法
 * 
 * **/
public class PersonDao 
{
	/*private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/test";
	    String username = "root";
	    String password = "123456";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}*/
	
	
		static String driver = "com.mysql.jdbc.Driver";
		static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		static String user = "root";
		static String password = "123456";
		static 
		{
			try 
			{
				Class.forName(driver);
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
	
	
	/**
	 * 增加员工
	 * @throws SQLException 
	 * */
	public boolean savePerson (Person person) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "INSERT INTO `person` VALUES (?,?,?,?,?,?,?)";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, String.valueOf(person.getpId()));
		params.setString(2, person.getpName());
		params.setString(3, person.getpSex());
		params.setString(4, String.valueOf(person.getpAge()));
		params.setString(5, String.valueOf(person.getpPost()));
		params.setString(6, person.getpStartTime());
		params.setString(7, String.valueOf(person.getpYear()));
		int count = params.executeUpdate();
		conn.close();
		return count==1?true:false;

	}
    /**
     * 删除员工
     * @throws SQLException 
     * */
	public boolean deletePerson (int pId) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "DELETE FROM `person` WHERE `pId` = ?";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, pId+"");
		int count = params.executeUpdate();
		conn.close();

		return count==1?true:false;

	}
	/**
	 * 修改员工
	 * @throws SQLException 
	 * */
	public boolean updataPerson (Person person) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "UPDATE `person`"
				+ " SET `pName`=?,`pSex`=?,`pAge`=?,`pPost`=?, "
				+ "`pStartTime`=?, `pYear`=? WHERE `pId`=?";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, String.valueOf(person.getpYear()));
		params.setString(2, person.getpName());
		params.setString(3, person.getpSex());
		params.setString(4, String.valueOf(person.getpAge()));
		params.setString(5, String.valueOf(person.getpPost()));
		params.setString(6, person.getpStartTime());
		params.setString(7, String.valueOf(person.getpId()));
		int count = params.executeUpdate();
		conn.close();

		return count==1?true:false;

	}
	/***
	 * 查询员工数量
	 * @throws SQLException 
	 * */
	public int selectPersonWithNum () throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT COUNT(1) FROM `person`";
		Object[]   count  = new QueryRunner().query(conn, sql,new ArrayHandler());
		conn.close();

		return  Integer.parseInt(count[0].toString()) ;
	}
	/***
	 * 查询所有员工
	 * pageNum 
	 * pageSize  
	 * @throws SQLException 
	 * */
	public  List<Person> selectPerosnWithList (int pageNum, int pageSize) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM `person` LIMIT ?,?";
		Object[] params = new Object[] { pageNum, pageSize};

		List<Person> list = new QueryRunner().query(conn, sql, new BeanListHandler<Person>(Person.class), params);
		conn.close();

		return list;

	}	
	/**
	 * 根据员工Id查询员工信息
	 * **/
	public Person selectPersonById (int pId)
	{
		return null;
	}
}
