package com.echo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.echo.Model.Experence;
import com.echo.Model.Person;

public class ExperenceDao 
{

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
 * 增加员工经验
 * @throws SQLException 
 * */
public boolean savePersonExperence (Experence experence) throws SQLException
{
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "INSERT INTO `experence` VALUES (?,?,?,?,?)";
	PreparedStatement params = conn.prepareStatement(sql);
	params.setString(1, experence.geteId()+"");
	params.setString(2, String.valueOf(experence.getpId()));
	params.setString(3, experence.geteType()+"");
	params.setString(4, experence.geteStartTime());
	params.setString(5, experence.geteProgress());
//	System.out.println(experence.geteProgress());
	int count = params.executeUpdate();
	conn.close();
	return count==1?true:false;

}
/**
 * 删除员工经验
 * @throws SQLException 
 * */
public boolean deletePersonExperence (int eId) throws SQLException
{
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "DELETE FROM `experence` WHERE `eId` = ?";
	PreparedStatement params = conn.prepareStatement(sql);
	params.setString(1, eId+"");
	int count = params.executeUpdate();
	conn.close();

	return count==1?true:false;

}
/**
 * 修改员工经验
 * @throws SQLException 
 * */
public boolean updataPersonExperence (Experence experence) throws SQLException
{
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "UPDATE `experence` SET `pId` = ?,`eType`=?,"
			+ "`eStartTime`=?,`eProgress`=? WHERE `eId` = ?";
	PreparedStatement params = conn.prepareStatement(sql);
	params.setString(1, String.valueOf(experence.getpId()));
	params.setString(2, experence.geteType()+"");
	params.setString(3, experence.geteStartTime());
	params.setString(4, experence.geteProgress());
	params.setString(5, experence.geteId()+"");
	int count = params.executeUpdate();
	conn.close();

	return count==1?true:false;

}
/***
 * 查询员工数量   、、、、、、、、、、、、、、、、、、、、、
 * @throws SQLException 
 * */
public int selectPersonExperenceWithNum () throws SQLException
{
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "SELECT COUNT(1) FROM `experence`";
	Object[]   count  = new QueryRunner().query(conn, sql,new ArrayHandler());
	conn.close();

	return  Integer.parseInt(count[0].toString()) ;
}
/***
 * 查询所有员工经验
 * pageNum 
 * pageSize  
 * @throws SQLException 
 * */
public  List<Experence> selectPerosnExperenceWithList (int pageNum, int pageSize) throws SQLException
{
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "SELECT * FROM `experence` LIMIT ?,?";
	Object[] params = new Object[] { pageNum, pageSize};

	List<Experence> list = new QueryRunner().query(conn, sql, new BeanListHandler<Experence>(Experence.class), params);
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
