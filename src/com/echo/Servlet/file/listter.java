package com.echo.Servlet.file;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class listter implements ServletContextListener ,ServletContextAttributeListener
{

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		System.out.println("----------------------------Bye~");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		System.out.println("-----------------------------hello!");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("上下文添加了属性");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("上下文删除了属性");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("上下文修改了属性");
	}

}
