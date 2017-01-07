package com.echo.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echo.Dao.ExperenceDao;
import com.echo.Model.Experence;

@WebServlet(urlPatterns={"/experenceService/*"})
public class ExperenceServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		String jspURL = null;
		String requestUrl = req.getRequestURI();
		boolean flag = false;

		if (requestUrl.endsWith("/tosavaExperence"))
		{
			jspURL = "/experence/savaExperence.jsp";
		}
		else if (requestUrl.endsWith("/savaExperence"))
		{
			Experence experence = new Experence();
			experence.seteId(Integer.parseInt(req.getParameter("eId")));
			experence.setpId(Integer.parseInt(req.getParameter("pId")));
			experence.seteType(Integer.parseInt(req.getParameter("eType")));
			experence.seteStartTime(req.getParameter("eStartTime"));
			experence.seteProgress(req.getParameter("eProgress"));
//			System.out.println("__________________");
//			System.out.println(req.getParameter("eProgress"));
			try 
			{
				flag = new ExperenceDao().savePersonExperence(experence);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

			if (flag)
			{
				jspURL = "/common/success.jsp";
			}
			else
			{
				jspURL = "/common/error.jsp";
			}
		}
		else  if (requestUrl.endsWith("/toupdataExperence"))
		{
			jspURL = "/experence/updataExperence.jsp";
		}
		else if (requestUrl.endsWith("/updataExperence"))
		{
			Experence experence = new Experence();
			experence.seteId(Integer.parseInt(req.getParameter("eId")));
			experence.setpId(Integer.parseInt(req.getParameter("pId")));
			experence.seteType(Integer.parseInt(req.getParameter("eType")));
			experence.seteStartTime(req.getParameter("eStartTime"));
			experence.seteProgress(req.getParameter("eProgress"));
			try 
			{
				flag = new ExperenceDao().updataPersonExperence(experence);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

			if (flag)
			{
				jspURL = "/common/success.jsp";
			}
			else
			{
				jspURL = "/common/error.jsp";
			}
		}
		else if (requestUrl.endsWith("/toselectPerosnExperenceWithList"))
		{
			try 
			{
				int countExperencePerson = new ExperenceDao().selectPersonExperenceWithNum();
				if (countExperencePerson>0)
				{
					List<Experence> list = new ExperenceDao().selectPerosnExperenceWithList(0, 10);
					req.setAttribute("countExperencePerson", countExperencePerson);
					req.setAttribute("list", list);
				}
				jspURL = "/experence/index.jsp";

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else if (requestUrl.endsWith("/deleteExperence"))
		{
			int eId = Integer.parseInt(req.getParameter("eId"));
			try 
			{
				flag = new ExperenceDao().deletePersonExperence(eId);
				
				if (flag)
				{
					jspURL = "/common/success.jsp";
				}
				else 
				{
					jspURL = "/common/error.jsp";
				}
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
		req.getRequestDispatcher(jspURL).forward(req, resp);
			}
}
