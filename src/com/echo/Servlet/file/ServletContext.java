package com.echo.Servlet.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/ServletContextServlet"})
public class ServletContext extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
			}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		String type = req.getParameter("type");
		javax.servlet.ServletContext context = getServletContext();
		resp.setCharacterEncoding("utf-8");
		switch(type)
		{
		case "add":
			context.setAttribute("name", "张三");
			resp.getWriter().write("添加了属性");
			break;
		case "repleace":
			context.setAttribute("name", "张三1");
			resp.getWriter().write("修改了属性");
			break;
		case "remove":
			context.removeAttribute("naem");
			resp.getWriter().write("移除了属性");
			break;
		default:
			resp.getWriter().write("上下文添加了属性");
			break;
		}

			}
}
