package com.echo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.echo.Model.Experence;
import com.echo.Model.Project;


/**
 * 项目列表的操作方法
 * */
public class ProjectDao 
{

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	static String user = "root";
	static String password = "123456";
	/**
	 * 增加项目
	 * @throws SQLException 
	 * */
	public boolean savaProject (Project project) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "INSERT INTO `project` VALUES(?,?,?)";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, project.getProjectNum()+"");
		params.setString(2, project.getProjectName());
		params.setString(3, project.geteId()+"");
		int count = params.executeUpdate();
		conn.close();
		return count==1?true:false;
		
	}
	
	/**
	 * 删除项目
	 * @throws SQLException 
	 * */
	public boolean deleteProject (int projectNum) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "DELETE  FROM `project` WHERE `p_num` = ?";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, projectNum+"");
		int count = params.executeUpdate();
		conn.close();
		return count==1?true:false;
		
	}
	/**
	 * 修改项目
	 * @throws SQLException 
	 * */
	public boolean updateProject (Project project) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "UPDATE `project` SET `p_name` = ? ,`eId` = ? WHERE `p_num` =?";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, project.getProjectName());
		params.setString(2, project.geteId()+"");
		params.setString(3, project.getProjectNum()+"");
		int count = params.executeUpdate();
		conn.close();
		return count==1?true:false;
	}
	/**
	 * 查询全部项目
	 * @throws SQLException 
	 * */
	public List<Project> selectProject () throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT `p_num` AS projectNum ,`p_name` AS projectName ,`eId` AS eId FROM `project`";
		List<Project> list = new QueryRunner().query(conn, sql, new BeanListHandler<Project>(Project.class));
		DbUtils.close(conn);
		return list;
		
	}
	
	/**
	 * 根据eId查询单个
	 * @throws SQLException 
	 * */
	public Project selectOneProject (int eId) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM `project` WHERE `eId` = ?";
		PreparedStatement params = conn.prepareStatement(sql);
		params.setString(1, eId+"");
		Project project = (Project) params.executeQuery();
		conn.close();		
		return project;
	}
	
	
	public int selectNumProject () throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT COUNT(1) FROM `project`";
		Object[]   count  = new QueryRunner().query(conn, sql,new ArrayHandler());
		return Integer.parseInt(count[0].toString());
		
	}
}
