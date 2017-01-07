package com.echo.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echo.Dao.ProjectDao;
import com.echo.Model.Experence;
import com.echo.Model.Project;

@WebServlet(urlPatterns={"/projectService/*"})
public class ProjectServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4335812999958956386L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		doPost(req, resp);

			}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		req.setCharacterEncoding("utf-8");
		String JspUrl = null;
		String requestUrl =req.getRequestURI();
		boolean Flag = false;
		
		if (requestUrl.endsWith("/tosavaProject"))
		{
			JspUrl="/project/savaProject.jsp";
		}
		else if (requestUrl.endsWith("/savaProject"))
		{
			String projectName = req.getParameter("p_name");
			String projectNum = req.getParameter("p_num");
			String eId = req.getParameter("eId");
			Project  project = new Project();
			project.seteId(Integer.parseInt(eId));
			project.setProjectName(projectName);
			project.setProjectNum(Integer.parseInt(projectNum));
			try 
			{
				Flag = new ProjectDao().savaProject(project);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			if (Flag)
			{
				JspUrl = "/common/success.jsp";
			}
			else 
			{
				JspUrl = "/common/error.jsp";
			}
		}
		else if (requestUrl.endsWith("/toupdataProject"))
		{
			JspUrl="/project/updataProject.jsp";
		}
		else if (requestUrl.endsWith("/updataProject"))
		{
			String projectName = req.getParameter("projectName");
			String projectNum = req.getParameter("projectNum");
			String eId = req.getParameter("eId");
			Project project = new Project();
			project.seteId(Integer.parseInt(eId));
			project.setProjectName(projectName);
			project.setProjectNum(Integer.parseInt(projectNum));
			try 
			{
				Flag = new ProjectDao().updateProject(project);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			if (Flag)
			{
				JspUrl = "/common/success.jsp";
			}
			else 
			{
				JspUrl = "/common/error.jsp";
			}
			
		}
		else if (requestUrl.endsWith("/deleteProject")) 
		{
			int projectNum = Integer.parseInt(req.getParameter("projectNum"));
			 
			try 
			{
				Flag = new ProjectDao().deleteProject(projectNum);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			if (Flag)
			{
				JspUrl = "/common/success.jsp";
			}
			else 
			{
				JspUrl = "/common/error.jsp";
			}
		}
		else if (requestUrl.endsWith("/toselectProject")) 
		{
			try
			{
				int countProject = new ProjectDao().selectNumProject();
				if (countProject>0)
				{
					 List<Project> projectList = new ProjectDao().selectProject();
					 req.setAttribute("projectList", projectList);
					 req.setAttribute("countProject", countProject);
				}
				JspUrl = "/project/index.jsp";

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else if (requestUrl.endsWith("")) 
		{
			
		}
		
		//控制转发
		req.getRequestDispatcher(JspUrl).forward(req, resp);

			}

}
