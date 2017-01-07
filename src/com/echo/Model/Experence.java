package com.echo.Model;

public class Experence {

	private int eId; 			  // 项目承建编号
	private int eType; 			 // 项目类型编号
	private String eStartTime;  // 项目开始时间
	private String eProgress;  // 项目进度
	private int pId;   	 	  //项目责任人编号

	public Experence() {
		super();
	}

	
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int geteType() {
		return eType;
	}

	public void seteType(int eType) {
		this.eType = eType;
	}

	public String geteStartTime() {
		return eStartTime;
	}

	public void seteStartTime(String eStartTime) {
		this.eStartTime = eStartTime;
	}

	public String geteProgress() {
		return eProgress;
	}

	public void seteProgress(String eProgress) {
		this.eProgress = eProgress;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}

	
}
