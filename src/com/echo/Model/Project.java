package com.echo.Model;

/*
 * 项目的实体类
 * **/
public class Project
{

	 private int  projectNum;   //项目编号
	 private String projectName;  //项目名称
	 private int eId;
	 
	 
	 
	 
	public Project() {
		super();
	}
	
	
	public int getProjectNum() {
		return projectNum;
	}
	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}
	 
	 
	 
	
}
